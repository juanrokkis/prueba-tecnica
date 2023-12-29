CREATE TABLE trazabilidad (
    id SERIAL PRIMARY KEY,
    fecha_hora_consulta TIMESTAMP,
    recurso_solicitado VARCHAR(255),
    cuerpo_consulta TEXT,
    respuesta_consulta TEXT,
    encabezados_consulta VARCHAR(255),
    info_autenticacion VARCHAR(255),
    metodo_http VARCHAR(10),
    tiempo_total_procesamiento INTEGER,
    codigo_http_respuesta_cliente INTEGER,
    codigo_http_respuesta_api_tullave INTEGER,
    ip_cliente VARCHAR(50)
);
