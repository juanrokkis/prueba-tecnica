package com.moovia.rickymicroservice.filter;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Collections;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.moovia.rickymicroservice.persistence.entity.Trazabilidad;
import com.moovia.rickymicroservice.persistence.repository.TrazabilidadRepository;
import com.moovia.rickymicroservice.util.MultipleReadHttpServletRequest;
import com.moovia.rickymicroservice.util.ResponseWrapper;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class TrazabilidadFilter implements Filter {

    private static final Logger log = LoggerFactory.getLogger(TrazabilidadFilter.class);

    @Autowired
    private TrazabilidadRepository trazabilidadRepository;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        ResponseWrapper responseWrapper = new ResponseWrapper((HttpServletResponse) response);

        Timestamp startTime = new Timestamp(System.currentTimeMillis());

        Trazabilidad trazabilidad = new Trazabilidad();
        trazabilidad.setFechaHoraConsulta(Timestamp.from(Instant.now()));
        trazabilidad.setRecursoSolicitado(httpRequest.getRequestURI());
        trazabilidad.setMetodoHttp(httpRequest.getMethod());
        trazabilidad.setIpCliente(httpRequest.getRemoteAddr());

        ObjectMapper objectMapper = new ObjectMapper();
        String encabezadosConsulta = objectMapper.writeValueAsString(Collections.list(httpRequest.getHeaderNames()));
        trazabilidad.setEncabezadosConsulta(encabezadosConsulta);

        MultipleReadHttpServletRequest multipleReadRequest = new MultipleReadHttpServletRequest(httpRequest);
        String cuerpoConsulta = multipleReadRequest.getReader().lines()
                .collect(Collectors.joining(System.lineSeparator()));
        trazabilidad.setCuerpoConsulta(cuerpoConsulta);

        // Autenticacion
        String infoAutenticacion = "obtenerInfoAutenticacion(httpRequest)";
        trazabilidad.setInfoAutenticacion(infoAutenticacion);

        chain.doFilter(request, responseWrapper);

        log.info("Status response: " + responseWrapper.getStatus());
        log.info("Body response: " + responseWrapper.getCaptureAsString());

        Timestamp endTime = new Timestamp(System.currentTimeMillis());
        float duration = endTime.getTime() - startTime.getTime();
        trazabilidad.setTiempoTotalProcesamiento((int) duration);

        trazabilidad.setCodigoHttpRespuestaCliente(responseWrapper.getStatus());

        String cuerpoRespuesta = responseWrapper.getCaptureAsString();
        trazabilidad.setRespuestaConsulta(cuerpoRespuesta);
        response.getWriter().write(cuerpoRespuesta);

        trazabilidad.setCodigoHttpRespuestaApiTullave(responseWrapper.getStatus());

        trazabilidadRepository.save(trazabilidad);
    }

}
