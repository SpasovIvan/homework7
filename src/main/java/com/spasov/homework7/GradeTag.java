package com.spasov.homework7;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.TagSupport;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class GradeTag extends TagSupport {

    @Override
    public int doStartTag() throws JspException {
        try {
            JspWriter out = pageContext.getOut();

            // Устанавливаем соединение с базой данных
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/java", "postgres", null);
            Statement statement = connection.createStatement();

            // Выполняем SQL-запрос
            ResultSet resultSet = statement.executeQuery("SELECT grade, COUNT(*) AS grade_count FROM students GROUP BY grade HAVING COUNT(*) > 1");

            // Выводим результаты запроса в HTML
            out.println("<table>");
            out.println("<tr><th>Оценка</th><th>Количество</th></tr>");
            while (resultSet.next()) {
                int grade = resultSet.getInt("grade");
                int gradeCount = resultSet.getInt("grade_count");
                out.println("<tr><td>" + grade + "</td><td>" + gradeCount + "</td></tr>");
            }
            out.println("</table>");

            // Закрываем соединение с базой данных
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            throw new JspException("Error in GradeTag tag", e);
        }
        return SKIP_BODY; // Пропускаем тело тега
    }
}
