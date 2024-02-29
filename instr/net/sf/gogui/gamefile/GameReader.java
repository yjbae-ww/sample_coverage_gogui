/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123820) $$ */// GameReader.java

package net.sf.gogui.gamefile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.io.IOException;
import java.util.Locale;
import net.sf.gogui.game.GameTree;
import net.sf.gogui.util.ErrorMessage;
import net.sf.gogui.util.FileUtil;
import net.sf.gogui.util.ProgressShow;
import net.sf.gogui.sgf.SgfReader;
import net.sf.gogui.xml.XmlReader;

/** Read a game and detect automatically if it is SGF or XML. */
public class GameReader {
	public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = GameReader.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ -8456717766111400247L,/* translation unit id   */ 9089905144037132018L,/* timestamp             */ 1709177900189L,/* source file name      */ "GameReader.java",/* probe size            */ 34);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_7e25d491705446f2(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}/**
	 * Construct reader and read a game.
	 * 
	 * @param progressShow
	 *            Callback to show progress, can be null
	 */
	public GameReader(File file, ProgressShow progressShow) throws ErrorMessage {$qualityscroll_cover_coverage_buffer_init();
		$qualityscroll_cover_jacov_probe_7e25d491705446f2(0);m_gameFile = new GameFile();
		GameFile.Format format = detectFormat(file);
		m_gameFile.m_file = file;
		m_gameFile.m_format = format;
		InputStream in;
		try {
			$qualityscroll_cover_jacov_probe_7e25d491705446f2(1);in = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			$qualityscroll_cover_jacov_probe_7e25d491705446f2(8);throw new ErrorMessage("File \"" + file + "\" not    found");
		}
		$qualityscroll_cover_jacov_probe_7e25d491705446f2(2);boolean $qualityscroll_cover_jacov_switch_bool_0 = false;switch (format) {
		case XML:if(!$qualityscroll_cover_jacov_switch_bool_0) { $qualityscroll_cover_jacov_probe_7e25d491705446f2(3); $qualityscroll_cover_jacov_switch_bool_0 = true; }  {
			$qualityscroll_cover_jacov_probe_7e25d491705446f2(6);XmlReader reader = new XmlReader(in, progressShow, file.length());
			m_tree = reader.getTree();
			m_warnings = reader.getWarnings();
		}
			break;
		case SGF:if(!$qualityscroll_cover_jacov_switch_bool_0) { $qualityscroll_cover_jacov_probe_7e25d491705446f2(4); $qualityscroll_cover_jacov_switch_bool_0 = true; }  {
			$qualityscroll_cover_jacov_probe_7e25d491705446f2(7);SgfReader reader = new SgfReader(in, file, progressShow, file.length());
			m_tree = reader.getTree();
			m_warnings = reader.getWarnings();
		}
			break;
		default: if(!$qualityscroll_cover_jacov_switch_bool_0) { $qualityscroll_cover_jacov_probe_7e25d491705446f2(5); $qualityscroll_cover_jacov_switch_bool_0 = true; }  break;}
	}

	public GameReader(File file) throws ErrorMessage {
		this(file, null);$qualityscroll_cover_coverage_buffer_init();$qualityscroll_cover_jacov_probe_7e25d491705446f2(9);
	}

	public GameFile getFile() {
		$qualityscroll_cover_jacov_probe_7e25d491705446f2(10);return m_gameFile;
	}

	public GameTree getTree() {
		$qualityscroll_cover_jacov_probe_7e25d491705446f2(11);return m_tree;
	}

	public String getWarnings() {
		$qualityscroll_cover_jacov_probe_7e25d491705446f2(12);return m_warnings;
	}

	private GameFile m_gameFile;

	private String m_warnings;

	private GameTree m_tree;

	private static GameFile.Format detectFormat(File file) {$qualityscroll_cover_coverage_buffer_init();
		$qualityscroll_cover_jacov_probe_7e25d491705446f2(13);String extension = FileUtil.getExtension(file);
		$qualityscroll_cover_jacov_probe_7e25d491705446f2(14);if ((extension != null) ? true : (!$qualityscroll_cover_jacov_probe_7e25d491705446f2(16) && false)) {
			$qualityscroll_cover_jacov_probe_7e25d491705446f2(15);extension = extension.toLowerCase(Locale.ENGLISH);
			$qualityscroll_cover_jacov_probe_7e25d491705446f2(17);if ((extension.equals("sgf")) ? true : (!$qualityscroll_cover_jacov_probe_7e25d491705446f2(19) && false))
				{$qualityscroll_cover_jacov_probe_7e25d491705446f2(18);return GameFile.Format.SGF;}
			$qualityscroll_cover_jacov_probe_7e25d491705446f2(20);if ((extension.equals("xml")) ? true : (!$qualityscroll_cover_jacov_probe_7e25d491705446f2(22) && false))
				{$qualityscroll_cover_jacov_probe_7e25d491705446f2(21);return GameFile.Format.XML;}
		}
		$qualityscroll_cover_jacov_probe_7e25d491705446f2(23);FileReader reader = null;
		try {
			$qualityscroll_cover_jacov_probe_7e25d491705446f2(24);reader = new FileReader(file);
			char[] buffer = new char[5];
			int n = reader.read(buffer, 0, 5);
			$qualityscroll_cover_jacov_probe_7e25d491705446f2(25);if ((n == 5 && new String(buffer).equals("<?xml")) ? true : (!$qualityscroll_cover_jacov_probe_7e25d491705446f2(27) && false))
				{$qualityscroll_cover_jacov_probe_7e25d491705446f2(26);return GameFile.Format.XML;}
		} catch (IOException e) {$qualityscroll_cover_jacov_probe_7e25d491705446f2(33);
		}
		try {
			$qualityscroll_cover_jacov_probe_7e25d491705446f2(28);if ((reader != null) ? true : (!$qualityscroll_cover_jacov_probe_7e25d491705446f2(30) && false))
				{$qualityscroll_cover_jacov_probe_7e25d491705446f2(29);reader.close();}
		} catch (IOException e) {$qualityscroll_cover_jacov_probe_7e25d491705446f2(32);
		}
		$qualityscroll_cover_jacov_probe_7e25d491705446f2(31);return GameFile.Format.SGF;
	}
}
