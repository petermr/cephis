package org.contentmine.pdf2svg2;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.contentmine.graphics.svg.SVGG;
import org.contentmine.graphics.svg.SVGSVG;
import org.junit.Assert;
import org.junit.Test;

public class SVGCreatorTest {

	@Test
	public void testCreator() throws InvalidPasswordException, IOException {
        File file = new File("src/test/resources/org/contentmine/pdf2svg2/",
                "custom-render-demo.pdf");
	    AMISVGCreator svgCreator = new AMISVGCreator();
	    SVGG svgg = svgCreator.createSVG(file);
	    File svgFile = new File("target/pdf2svg2/examples/custom.svg");
		SVGSVG.wrapAndWriteAsSVG(svgg, svgFile);
	    Assert.assertTrue("svg file exists", svgFile.exists());
	}

	@Test
	public void testCreator1() throws InvalidPasswordException, IOException {
        File file = new File("src/test/resources/org/contentmine/pdf2svg/", "page6.pdf");
	    AMISVGCreator svgCreator = new AMISVGCreator();
	    SVGG svgg = svgCreator.createSVG(file);
	    File svgFile = new File("target/pdf2svg2/examples/page6.svg");
		SVGSVG.wrapAndWriteAsSVG(svgg, svgFile);
	    Assert.assertTrue("svg file exists", svgFile.exists());
	}

}