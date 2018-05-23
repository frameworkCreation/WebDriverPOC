<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
<xsl:template match="Results">  
    <html>
	<body STYLE="font-family: Times New Roman; font-size: 10px">
	<table width="100%" cellspacing="0">
		<tr>
			<td><center><h2><xsl:value-of select="@Build"/></h2></center></td>
		</tr>
		<tr>
			<td><B>Total Test Cases: <xsl:value-of select="@Total"/></B></td>
		</tr>
		<tr>		
			<td>
				<SPAN STYLE="background-color:Cyan"><B><xsl:value-of select="@BenchmarkMessage"/></B></SPAN>
			</td>
		</tr>
		<tr>
			<td><SPAN STYLE="background-color:#EEFFEE">PASS With Warning(s): <xsl:value-of select="@PassWithWarnings"/></SPAN>
		
			    <SPAN STYLE="background-color:#CCFFCC">PASS: <xsl:value-of select="@Pass"/></SPAN>
		
			    <SPAN STYLE="background-color:#FFCCCC">FAIL: <xsl:value-of select="@Fail"/></SPAN>
		
			    <SPAN STYLE="background-color:#FF7A7A">ERROR: <xsl:value-of select="@Error"/></SPAN></td>
		</tr>
	</table>
	<BR/>	
	<table border="1" bordercolor="gray" width="100%" cellspacing="0" cellpadding="3">
      		<tr>
        	<th>TC ID</th>
        	<th>Test Case Description</th>
			<th>Status</th>
			<th>Status Date</th>
			<th>Remarks</th>
			<th>Flow</th>
			<th>Image Link</th>			
      		</tr>		
		<xsl:apply-templates/>
	</table>      		
    	</body>
    </html>
</xsl:template>
<xsl:template match="TestCaseResult">
	<xsl:if test="@Status = 'PASS'">
		<tr bgcolor="#CCFFCC">
			<td><xsl:value-of select="@TCID"/></td>
			<td><xsl:value-of select="text()"/></td>
			<td><xsl:value-of select="@Status"/></td>
			<td><xsl:value-of select="@StatusDate"/></td>
			<td><xsl:value-of select="@Remarks" disable-output-escaping="yes"/></td>
			<td><xsl:value-of select="@Flow" disable-output-escaping="yes"/></td>			
			<td>
    				<xsl:call-template name="output-tokens">
            				<xsl:with-param name="list"><xsl:value-of select="@ImgLink" disable-output-escaping="yes"/></xsl:with-param>
            				<xsl:with-param name="delimiter">>></xsl:with-param>
    				</xsl:call-template>		
			</td>
		</tr>
	</xsl:if>
	<xsl:if test="@Status = 'FAIL'">
		<tr bgcolor="#FFCCCC">
			<td><xsl:value-of select="@TCID"/></td>
			<td><xsl:value-of select="text()"/></td>
			<td><xsl:value-of select="@Status"/></td>
			<td><xsl:value-of select="@StatusDate"/></td>
			<td><xsl:value-of select="@Remarks" disable-output-escaping="yes"/></td>
			<td><xsl:value-of select="@Flow" disable-output-escaping="yes"/></td>			
			<td>
    				<xsl:call-template name="output-tokens">
            				<xsl:with-param name="list"><xsl:value-of select="@ImgLink" disable-output-escaping="yes"/></xsl:with-param>
            				<xsl:with-param name="delimiter">>></xsl:with-param>
    				</xsl:call-template>		
			</td>
		</tr>
	</xsl:if>
	<xsl:if test="@Status = 'PASS with Warning(s)'">
		<tr bgcolor="#EEFFEE">
			<td><xsl:value-of select="@TCID"/></td>
			<td><xsl:value-of select="text()"/></td>
			<td><xsl:value-of select="@Status"/></td>
			<td><xsl:value-of select="@StatusDate"/></td>
			<td><xsl:value-of select="@Remarks" disable-output-escaping="yes"/></td>
			<td><xsl:value-of select="@Flow" disable-output-escaping="yes"/></td>			
			<td>
    				<xsl:call-template name="output-tokens">
            				<xsl:with-param name="list"><xsl:value-of select="@ImgLink" disable-output-escaping="yes"/></xsl:with-param>
            				<xsl:with-param name="delimiter">>></xsl:with-param>
    				</xsl:call-template>		
			</td>
		</tr>
	</xsl:if>
	<xsl:if test="@Status = 'ERROR'">
		<tr bgcolor="#FF7A7A">
			<td><xsl:value-of select="@TCID"/></td>
			<td><xsl:value-of select="text()"/></td>
			<td><xsl:value-of select="@Status"/></td>
			<td><xsl:value-of select="@StatusDate"/></td>
			<td><xsl:value-of select="@Remarks" disable-output-escaping="yes"/></td>
			<td><xsl:value-of select="@Flow" disable-output-escaping="yes"/></td>			
			<td>
    				<xsl:call-template name="output-tokens">
            				<xsl:with-param name="list"><xsl:value-of select="@ImgLink" disable-output-escaping="yes"/></xsl:with-param>
            				<xsl:with-param name="delimiter">>></xsl:with-param>
    				</xsl:call-template>		
			</td>
		</tr>
	</xsl:if>
</xsl:template>

<xsl:template name="output-tokens">
    <xsl:param name="list" />
    <xsl:param name="delimiter" />

    <xsl:variable name="newlist">
        <xsl:choose>
            <xsl:when test="contains($list, $delimiter)"><xsl:value-of select="normalize-space($list)" /></xsl:when>           
            <xsl:otherwise><xsl:value-of select="concat(normalize-space($list), $delimiter)"/></xsl:otherwise>
        </xsl:choose>
    </xsl:variable>
    <xsl:variable name="first" select="substring-before($newlist, $delimiter)" />
    <xsl:variable name="remaining" select="substring-after($newlist, $delimiter)" />

    <xsl:if test="$first != ''">
    	<xsl:choose>
    		<xsl:when test="$remaining">
    			<num><a><xsl:attribute name="href"><xsl:value-of select="$first" /></xsl:attribute>Image</a> >> </num>   
    		</xsl:when>
    		<xsl:when test="not($remaining)">
    			<num><a><xsl:attribute name="href"><xsl:value-of select="$first" /></xsl:attribute>Image</a></num>
    		</xsl:when>
    	</xsl:choose>
    </xsl:if>

    <xsl:if test="$remaining">
        <xsl:call-template name="output-tokens">
            <xsl:with-param name="list" select="$remaining" />
            <xsl:with-param name="delimiter"><xsl:value-of select="$delimiter"/></xsl:with-param>
        </xsl:call-template>
    </xsl:if>
</xsl:template>

</xsl:stylesheet>