import psycopg2
import os

db_host = os.getenv('DATABASE_HOST')
db_port = os.getenv('DATABASE_PORT')
db_name = os.getenv('DATABASE_NAME')
db_user = os.getenv('DATABASE_USER')
db_password = os.getenv('DATABASE_PASSWORD')

conn = psycopg2.connect(
    host=db_host,
    port=db_port,
    dbname=db_name,
    user=db_user,
    password=db_password
)

def guardar_trazabilidad(id, fecha_hora_consulta, recurso_solicitado, cuerpo_consulta, encabezados_consulta, info_autenticacion, metodo_http, tiempo_total_procesamiento, codigo_http_respuesta_cliente, codigo_http_respuesta_api_tullave, ip_cliente):
    sql = """
        INSERT INTO trazabilidad (id, fecha_hora_consulta, recurso_solicitado, cuerpo_consulta, encabezados_consulta, info_autenticacion, metodo_http, tiempo_total_procesamiento, codigo_http_respuesta_cliente, codigo_http_respuesta_api_tullave, ip_cliente)
        VALUES (NOW(), %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
    """
    with conn.cursor() as cursor:
        cursor.execute(sql, (id, fecha_hora_consulta, recurso_solicitado, cuerpo_consulta, encabezados_consulta, info_autenticacion, metodo_http, tiempo_total_procesamiento, codigo_http_respuesta_cliente, codigo_http_respuesta_api_tullave, ip_cliente))
    conn.commit()
