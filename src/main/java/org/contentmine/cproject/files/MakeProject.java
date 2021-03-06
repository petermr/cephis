package org.contentmine.cproject.files;

import java.io.File;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/** runs the CProject "makeProject" command with default files and regex.
 * 
 * @author pm286
 *
 */
public class MakeProject {
	private static final Logger LOG = Logger.getLogger(MakeProject.class);
	static {
		LOG.setLevel(Level.DEBUG);
	}
	
	public static void main(String[] args) throws Exception {
		if (args.length == 0) {
			help();
		} else if (args.length > 1) {
			LOG.debug("only one arg allowed");
			help();
		} else {
			// try absolute filename
			File dir = new File(args[0]);
			String command = " --project "+ dir + CProject.MAKE_PROJECT;
			LOG.debug(">> "+command);
			if (!checkDirectory(dir)) {
				dir = new File(".", args[0]);
			}
			if (checkDirectory(dir)) {
				LOG.debug("dir "+dir.getCanonicalPath());
				CProject cProject = new CProject(dir);
				
				command = " --project "+ dir + CProject.MAKE_PROJECT;
				LOG.debug(">> "+command);
				cProject.run(command);
			} else {
				LOG.error("cannot find absolute or relative file: "+args[0]);
			}
		}
	}

	private static boolean checkDirectory(File dir) {
		boolean exists = true;
		if (!dir.exists() || !dir.isDirectory()) {
			LOG.debug("Cannot find directory: "+dir+ "( give full filename or relative to current Dir ");
			exists = false;
		}
		return exists;
	}

	private static void help() {
		System.err.println(" makeProject  makes project from a directory of PDFs or other files");
		System.err.println("    makeProject <dirname> ");
	}
}
