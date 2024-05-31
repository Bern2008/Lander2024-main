CREATE VIEW Puntuaciones_Por_Tiempos AS
    SELECT U.nick, P.tiempo, P.fecha
        FROM usuario U INNER JOIN puntuacion P
            ON U.id_usuario = P.id_usuario
            ORDER BY tiempo ASC LIMIT 10;
