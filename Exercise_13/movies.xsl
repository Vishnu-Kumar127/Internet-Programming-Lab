<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  
  <xsl:template match="/">
    <html>
      <head>
        <title>Movie Ratings</title>
        <style>
          table {
            border-collapse: collapse;
            width: 100%;
          }
          th, td {
            text-align: left;
            padding: 8px;
          }
          tr:nth-child(even) {
            background-color: #f2f2f2;
          }
          th {
            background-color: #4CAF50;
            color: white;
          }
          .high-rating {
            background-color: #7FFF00;
            font-weight: bold;
          }
        </style>
      </head>
      <body>
        <h1>Movie Ratings</h1>
        <table>
          <tr>
            <th>Title</th>
            <th>Director</th>
            <th>Rating</th>
          </tr>
          <xsl:for-each select="movies/movie">
            <tr>
              <td><xsl:value-of select="title"/></td>
              <td><xsl:value-of select="director"/></td>
              <td>
                <xsl:choose>
                  <xsl:when test="rating &gt;= 8">
                    <span class="high-rating"><xsl:value-of select="rating"/></span>
                  </xsl:when>
                  <xsl:otherwise>
                    <xsl:value-of select="rating"/>
                  </xsl:otherwise>
                </xsl:choose>
              </td>
            </tr>
          </xsl:for-each>
        </table>
      </body>
    </html>
  </xsl:template>
  
</xsl:stylesheet>
