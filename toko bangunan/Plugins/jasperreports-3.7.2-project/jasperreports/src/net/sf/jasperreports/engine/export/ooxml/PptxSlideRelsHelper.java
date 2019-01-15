/*
 * JasperReports - Free Java Reporting Library.
 * Copyright (C) 2001 - 2009 Jaspersoft Corporation. All rights reserved.
 * http://www.jaspersoft.com
 *
 * Unless you have purchased a commercial license agreement from Jaspersoft,
 * the following license terms apply:
 *
 * This program is part of JasperReports.
 *
 * JasperReports is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 *(at your option) any later version.
 *
 * JasperReports is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with JasperReports. If not, see <http://www.gnu.org/licenses/>.
 */
package net.sf.jasperreports.engine.export.ooxml;

import java.io.Writer;
import java.util.HashSet;
import java.util.Set;


/**
 * @author Teodor Danciu (teodord@users.sourceforge.net)
 * @version $Id: OoxmlZip.java 2908 2009-07-21 14:32:01Z teodord $
 */
public class PptxSlideRelsHelper extends BaseHelper
{

	private Set<String> imageNames = new HashSet<String>();
	
	/**
	 * 
	 */
	public PptxSlideRelsHelper(Writer writer)
	{
		super(writer);
	}

	/**
	 * 
	 */
	public void exportHeader()
	{
		write("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n");
		write("<Relationships xmlns=\"http://schemas.openxmlformats.org/package/2006/relationships\">\n");
		write("<Relationship Id=\"rId1\" Type=\"http://schemas.openxmlformats.org/officeDocument/2006/relationships/slideLayout\" Target=\"../slideLayouts/slideLayout1.xml\"/>\n");
	}
	
	/**
	 * 
	 */
	public void exportImage(String imageName)
	{
		if (!imageNames.contains(imageName))
		{
			write(" <Relationship Id=\"" + imageName + "\" Type=\"http://schemas.openxmlformats.org/officeDocument/2006/relationships/image\" Target=\"../media/" + imageName + "\"/>\n");
			imageNames.add(imageName);
		}
	}
	
	/**
	 * 
	 */
	public void exportFooter()
	{
		write("</Relationships>\n");
	}
	
}
