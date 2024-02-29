/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123823) $$ */// ResultFile.java

package net.sf.gogui.tools.twogtp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;
import net.sf.gogui.game.ConstNode;
import net.sf.gogui.game.ConstGame;
import net.sf.gogui.go.Komi;
import net.sf.gogui.sgf.SgfError;
import net.sf.gogui.sgf.SgfReader;
import net.sf.gogui.sgf.SgfWriter;
import net.sf.gogui.util.ErrorMessage;
import net.sf.gogui.util.Platform;
import net.sf.gogui.util.StringUtil;
import net.sf.gogui.util.Table;
import net.sf.gogui.xml.XmlWriter;
import net.sf.gogui.version.Version;

public class ResultFile
{
    public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = ResultFile.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ -7049447742059748813L,/* translation unit id   */ 7946858637315115774L,/* timestamp             */ 1709177903860L,/* source file name      */ "ResultFile.java",/* probe size            */ 112);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_6e48e9d38d698afe(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}public ResultFile(boolean force, Program black, Program white,
                      Program referee, int numberGames, int size, Komi komi,
                      String filePrefix, Openings openings, boolean alternate,
                      boolean useXml, int numberThreads) throws ErrorMessage
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_6e48e9d38d698afe(0);m_filePrefix = filePrefix;
        m_alternate = alternate;
        m_numberGames = numberGames;
        m_useXml = useXml;
        m_numberThreads = numberThreads;
        m_lockFile = new File(filePrefix + ".lock");
        acquireLock();
        m_tableFile = new File(filePrefix + ".dat");
        $qualityscroll_cover_jacov_probe_6e48e9d38d698afe(1);if ((force) ? true : (!$qualityscroll_cover_jacov_probe_6e48e9d38d698afe(3) && false))
        {
            $qualityscroll_cover_jacov_probe_6e48e9d38d698afe(2);if ((m_tableFile.exists() && ! m_tableFile.delete()) ? true : (!$qualityscroll_cover_jacov_probe_6e48e9d38d698afe(5) && false))
                {$qualityscroll_cover_jacov_probe_6e48e9d38d698afe(4);throw new ErrorMessage("Could not delete file '"
                                       + m_tableFile + "'");}
        }
        $qualityscroll_cover_jacov_probe_6e48e9d38d698afe(6);if ((m_tableFile.exists()) ? true : (!$qualityscroll_cover_jacov_probe_6e48e9d38d698afe(8) && false))
        {
            $qualityscroll_cover_jacov_probe_6e48e9d38d698afe(7);m_table = readTable(m_tableFile, numberGames, m_gameExists);
            m_nextGameIndex = 0;
            $qualityscroll_cover_jacov_probe_6e48e9d38d698afe(9);while ((m_gameExists.contains(m_nextGameIndex)) ? true : (!$qualityscroll_cover_jacov_probe_6e48e9d38d698afe(11) && false))
            {
                $qualityscroll_cover_jacov_probe_6e48e9d38d698afe(10);++m_nextGameIndex;
                $qualityscroll_cover_jacov_probe_6e48e9d38d698afe(13);if ((numberGames > 0 && m_nextGameIndex > numberGames) ? true : (!$qualityscroll_cover_jacov_probe_6e48e9d38d698afe(15) && false))
                {
                    $qualityscroll_cover_jacov_probe_6e48e9d38d698afe(14);m_nextGameIndex = -1;
                    break;
                }
            }
            $qualityscroll_cover_jacov_probe_6e48e9d38d698afe(12);readGames();
        }
        else
        {
            $qualityscroll_cover_jacov_probe_6e48e9d38d698afe(16);m_table = createTable(black, white, referee, size, komi, openings);
            m_nextGameIndex = 0;
        }
    }

    public synchronized void addResult(int gameIndex, ConstGame game,
                                       String resultBlack, String resultWhite,
                                       String resultReferee,
                                       boolean alternated, int numberMoves,
                                       boolean error, String errorMessage,
                                       double timeBlack, double timeWhite,
                                       double cpuTimeBlack,
                                       double cpuTimeWhite)
        throws ErrorMessage
    {
        $qualityscroll_cover_jacov_probe_6e48e9d38d698afe(17);ArrayList<Compare.Placement> moves
            = Compare.getPlacements(game.getTree().getRootConst());
        String duplicate =
            Compare.checkDuplicate(game.getBoard(), moves, m_games,
                                   m_alternate, alternated);
        NumberFormat format = StringUtil.getNumberFormat(1);
        m_table.startRow();
        m_table.set("GAME", Integer.toString(gameIndex));
        m_table.set("RES_B", resultBlack);
        m_table.set("RES_W", resultWhite);
        m_table.set("RES_R", resultReferee);
        m_table.set("ALT", ((alternated) ? ($qualityscroll_cover_jacov_probe_6e48e9d38d698afe(18) || true) : (!$qualityscroll_cover_jacov_probe_6e48e9d38d698afe(19) && false)) ? "1" : "0");
        m_table.set("DUP", duplicate);
        m_table.set("LEN", numberMoves);
        m_table.set("TIME_B", format.format(timeBlack));
        m_table.set("TIME_W", format.format(timeWhite));
        m_table.set("CPU_B", format.format(cpuTimeBlack));
        m_table.set("CPU_W", format.format(cpuTimeWhite));
        m_table.set("ERR", ((error) ? ($qualityscroll_cover_jacov_probe_6e48e9d38d698afe(20) || true) : (!$qualityscroll_cover_jacov_probe_6e48e9d38d698afe(21) && false)) ? "1" : "0");
        m_table.set("ERR_MSG", errorMessage);

        // The code does not rely on the table being sorted by game number,
        // but it looks nicer for the user.
        int rowEnd = m_table.getNumberRows();
        int rowBegin = rowEnd - m_numberThreads;
        $qualityscroll_cover_jacov_probe_6e48e9d38d698afe(22);if ((rowBegin < 0) ? true : (!$qualityscroll_cover_jacov_probe_6e48e9d38d698afe(24) && false))
            {$qualityscroll_cover_jacov_probe_6e48e9d38d698afe(23);rowBegin = 0;}
        // If the run was terminated and continued with a different number
        // of threads, there could be a gap between gameIndex and
        // getNumberRows() larger than m_numberThreads
        $qualityscroll_cover_jacov_probe_6e48e9d38d698afe(25);if ((gameIndex < rowBegin) ? true : (!$qualityscroll_cover_jacov_probe_6e48e9d38d698afe(27) && false))
            {$qualityscroll_cover_jacov_probe_6e48e9d38d698afe(26);rowBegin = gameIndex;}
        $qualityscroll_cover_jacov_probe_6e48e9d38d698afe(28);m_table.sortByIntColumn("GAME", rowBegin, rowEnd);

        File tmpFile = new File(m_tableFile.getAbsolutePath() + ".new");
        try
        {
            $qualityscroll_cover_jacov_probe_6e48e9d38d698afe(29);m_table.save(tmpFile);
            $qualityscroll_cover_jacov_probe_6e48e9d38d698afe(30);if ((Platform.isWindows()) ? true : (!$qualityscroll_cover_jacov_probe_6e48e9d38d698afe(32) && false))
                // File.renameTo() fails on Windows if target exists
                {$qualityscroll_cover_jacov_probe_6e48e9d38d698afe(31);m_tableFile.delete();}
            $qualityscroll_cover_jacov_probe_6e48e9d38d698afe(33);tmpFile.renameTo(m_tableFile);
        }
        catch (IOException e)
        {
            $qualityscroll_cover_jacov_probe_6e48e9d38d698afe(42);throw new ErrorMessage("Could not write to: " + m_tableFile);
        }
        $qualityscroll_cover_jacov_probe_6e48e9d38d698afe(34);File file = getFile(gameIndex);
        try
        {
            $qualityscroll_cover_jacov_probe_6e48e9d38d698afe(35);OutputStream out = new FileOutputStream(file);
            $qualityscroll_cover_jacov_probe_6e48e9d38d698afe(36);if ((m_useXml) ? true : (!$qualityscroll_cover_jacov_probe_6e48e9d38d698afe(38) && false))
                {$qualityscroll_cover_jacov_probe_6e48e9d38d698afe(37);new XmlWriter(out, game.getTree(),
                              "gogui-twogtp:" + Version.get());}
            else
                {$qualityscroll_cover_jacov_probe_6e48e9d38d698afe(40);new SgfWriter(out, game.getTree(),
                              "gogui-twogtp", Version.get());}
            $qualityscroll_cover_jacov_probe_6e48e9d38d698afe(39);m_games.put(gameIndex, moves);
        }
        catch (FileNotFoundException e)
        {
            $qualityscroll_cover_jacov_probe_6e48e9d38d698afe(41);throw new ErrorMessage("Could not save " + file + ": "
                                   + e.getMessage());
        }
    }

    public void close()
    {
        try
        {
            $qualityscroll_cover_jacov_probe_6e48e9d38d698afe(43);m_lockFileChannel.close();
        }
        catch (IOException e)
        {
            $qualityscroll_cover_jacov_probe_6e48e9d38d698afe(47);System.err.println("Could not close '" + m_lockFile + "'");
        }
        $qualityscroll_cover_jacov_probe_6e48e9d38d698afe(44);if ((! m_lockFile.delete()) ? true : (!$qualityscroll_cover_jacov_probe_6e48e9d38d698afe(46) && false))
            {$qualityscroll_cover_jacov_probe_6e48e9d38d698afe(45);System.err.println("Could not delete '" + m_lockFile + "'");}
    }

    public synchronized int getNextGameIndex()
    {
        $qualityscroll_cover_jacov_probe_6e48e9d38d698afe(48);if ((m_nextGameIndex != -1) ? true : (!$qualityscroll_cover_jacov_probe_6e48e9d38d698afe(50) && false))
            {$qualityscroll_cover_jacov_probe_6e48e9d38d698afe(49);while ((m_gameExists.contains(m_nextGameIndex)) ? true : (!$qualityscroll_cover_jacov_probe_6e48e9d38d698afe(52) && false))
            {
                $qualityscroll_cover_jacov_probe_6e48e9d38d698afe(51);++m_nextGameIndex;
                $qualityscroll_cover_jacov_probe_6e48e9d38d698afe(57);if ((m_numberGames > 0 && m_nextGameIndex >= m_numberGames) ? true : (!$qualityscroll_cover_jacov_probe_6e48e9d38d698afe(59) && false))
                {
                    $qualityscroll_cover_jacov_probe_6e48e9d38d698afe(58);m_nextGameIndex = -1;
                    break;
                }
            }}
        $qualityscroll_cover_jacov_probe_6e48e9d38d698afe(53);if ((m_nextGameIndex != -1) ? true : (!$qualityscroll_cover_jacov_probe_6e48e9d38d698afe(55) && false))
            {$qualityscroll_cover_jacov_probe_6e48e9d38d698afe(54);m_gameExists.add(m_nextGameIndex);}
        $qualityscroll_cover_jacov_probe_6e48e9d38d698afe(56);return m_nextGameIndex;
    }

    private final boolean m_alternate;

    private final boolean m_useXml;

    private final TreeSet<Integer> m_gameExists = new TreeSet<Integer>();

    private int m_nextGameIndex;

    private final int m_numberGames;

    private final int m_numberThreads;

    private final String m_filePrefix;

    private final File m_tableFile;

    private final File m_lockFile;

    private FileChannel m_lockFileChannel;

    private final Table m_table;

    private final TreeMap<Integer, ArrayList<Compare.Placement>> m_games
        = new TreeMap<Integer, ArrayList<Compare.Placement>>();

    private void acquireLock() throws ErrorMessage
    {
        try
        {
            $qualityscroll_cover_jacov_probe_6e48e9d38d698afe(60);m_lockFile.createNewFile();
            m_lockFileChannel
                = new RandomAccessFile(m_lockFile, "rw").getChannel();
            FileLock lock = m_lockFileChannel.tryLock();
            $qualityscroll_cover_jacov_probe_6e48e9d38d698afe(61);if ((lock == null) ? true : (!$qualityscroll_cover_jacov_probe_6e48e9d38d698afe(63) && false))
                {$qualityscroll_cover_jacov_probe_6e48e9d38d698afe(62);throw new ErrorMessage("Could not get lock on file '"
                                       + m_lockFile
                            + "': already used by another instance of TwoGtp");}
        }
        catch (IOException e)
        {
            $qualityscroll_cover_jacov_probe_6e48e9d38d698afe(64);throw new ErrorMessage("Could not lock file '" + m_lockFile
                                   + "': " + e.getMessage());
        }
    }

    private Table createTable(Program black, Program white, Program referee,
                              int size, Komi komi, Openings openings)
    {
        $qualityscroll_cover_jacov_probe_6e48e9d38d698afe(65);ArrayList<String> columns = new ArrayList<String>();
        columns.add("GAME");
        columns.add("RES_B");
        columns.add("RES_W");
        columns.add("RES_R");
        columns.add("ALT");
        columns.add("DUP");
        columns.add("LEN");
        columns.add("TIME_B");
        columns.add("TIME_W");
        columns.add("CPU_B");
        columns.add("CPU_W");
        columns.add("ERR");
        columns.add("ERR_MSG");
        Table table = new Table(columns);
        black.setTableProperties(table);
        white.setTableProperties(table);
        $qualityscroll_cover_jacov_probe_6e48e9d38d698afe(66);if ((referee == null) ? true : (!$qualityscroll_cover_jacov_probe_6e48e9d38d698afe(68) && false))
            {$qualityscroll_cover_jacov_probe_6e48e9d38d698afe(67);table.setProperty("Referee", "-");}
        else
            {$qualityscroll_cover_jacov_probe_6e48e9d38d698afe(76);referee.setTableProperties(table);}
        $qualityscroll_cover_jacov_probe_6e48e9d38d698afe(69);table.setProperty("Size", Integer.toString(size));
        table.setProperty("Komi", komi.toString());
        $qualityscroll_cover_jacov_probe_6e48e9d38d698afe(70);if ((openings != null) ? true : (!$qualityscroll_cover_jacov_probe_6e48e9d38d698afe(72) && false))
            {$qualityscroll_cover_jacov_probe_6e48e9d38d698afe(71);table.setProperty("Openings",
                                openings.getDirectory() + " ("
                                + openings.getNumber() + " files)");}
        $qualityscroll_cover_jacov_probe_6e48e9d38d698afe(73);table.setProperty("Date", StringUtil.getDate());
        table.setProperty("Host", Platform.getHostInfo());
        table.setProperty("Xml", ((m_useXml) ? ($qualityscroll_cover_jacov_probe_6e48e9d38d698afe(74) || true) : (!$qualityscroll_cover_jacov_probe_6e48e9d38d698afe(75) && false)) ? "1" : "0");
        return table;
    }

    private File getFile(int gameIndex)
    {
        $qualityscroll_cover_jacov_probe_6e48e9d38d698afe(77);if ((m_useXml) ? true : (!$qualityscroll_cover_jacov_probe_6e48e9d38d698afe(79) && false))
            {$qualityscroll_cover_jacov_probe_6e48e9d38d698afe(78);return new File(m_filePrefix + "-" + gameIndex + ".xml");}
        else
            {$qualityscroll_cover_jacov_probe_6e48e9d38d698afe(80);return new File(m_filePrefix + "-" + gameIndex + ".sgf");}
    }

    private void readGames()
    {
        $qualityscroll_cover_jacov_probe_6e48e9d38d698afe(81);for (int n = 0; (n < m_numberGames) ? true : (!$qualityscroll_cover_jacov_probe_6e48e9d38d698afe(83) && false); ++n)
        {
            $qualityscroll_cover_jacov_probe_6e48e9d38d698afe(82);if ((! m_gameExists.contains(n)) ? true : (!$qualityscroll_cover_jacov_probe_6e48e9d38d698afe(85) && false))
                {$qualityscroll_cover_jacov_probe_6e48e9d38d698afe(84);continue;}
            $qualityscroll_cover_jacov_probe_6e48e9d38d698afe(86);File file = getFile(n);
            $qualityscroll_cover_jacov_probe_6e48e9d38d698afe(87);if ((! file.exists()) ? true : (!$qualityscroll_cover_jacov_probe_6e48e9d38d698afe(89) && false))
            {
                $qualityscroll_cover_jacov_probe_6e48e9d38d698afe(88);System.err.println("Game " + file + " not found");
                continue;
            }
            $qualityscroll_cover_jacov_probe_6e48e9d38d698afe(90);if ((! file.exists()) ? true : (!$qualityscroll_cover_jacov_probe_6e48e9d38d698afe(92) && false))
                {$qualityscroll_cover_jacov_probe_6e48e9d38d698afe(91);return;}
            try
            {
                $qualityscroll_cover_jacov_probe_6e48e9d38d698afe(93);FileInputStream fileStream = new FileInputStream(file);
                SgfReader reader = new SgfReader(fileStream, file, null, 0);
                ConstNode root = reader.getTree().getRoot();
                m_games.put(n, Compare.getPlacements(root));
            }
            catch (SgfError e)
            {
                $qualityscroll_cover_jacov_probe_6e48e9d38d698afe(94);System.err.println("Error reading " + file + ": " +
                                   e.getMessage());
            }
            catch (Exception e)
            {
                $qualityscroll_cover_jacov_probe_6e48e9d38d698afe(95);System.err.println("Error reading " + file + ": " +
                                   e.getMessage());
            }
        }
    }

    private static Table readTable(File file, int numberGames,
                                   TreeSet<Integer> gameExists)
        throws ErrorMessage
    {$qualityscroll_cover_coverage_buffer_init();
        $qualityscroll_cover_jacov_probe_6e48e9d38d698afe(96);Table table = new Table();
        try
        {
            $qualityscroll_cover_jacov_probe_6e48e9d38d698afe(97);table.read(file);
            int numberRows = table.getNumberRows();
            $qualityscroll_cover_jacov_probe_6e48e9d38d698afe(98);if ((numberGames > 0 && numberRows >= numberGames) ? true : (!$qualityscroll_cover_jacov_probe_6e48e9d38d698afe(100) && false))
                {$qualityscroll_cover_jacov_probe_6e48e9d38d698afe(99);throw new ErrorMessage("File " + file + " already contains "
                                       + numberRows + " games");}
            $qualityscroll_cover_jacov_probe_6e48e9d38d698afe(101);for (int i = 0; (i < numberRows) ? true : (!$qualityscroll_cover_jacov_probe_6e48e9d38d698afe(103) && false); ++i)
            {
                $qualityscroll_cover_jacov_probe_6e48e9d38d698afe(102);int gameIndex = Integer.parseInt(table.get("GAME", i));
                $qualityscroll_cover_jacov_probe_6e48e9d38d698afe(105);if ((gameIndex < 0) ? true : (!$qualityscroll_cover_jacov_probe_6e48e9d38d698afe(107) && false))
                    {$qualityscroll_cover_jacov_probe_6e48e9d38d698afe(106);throw new ErrorMessage("Invalid file format: " + file);}
                $qualityscroll_cover_jacov_probe_6e48e9d38d698afe(108);gameExists.add(gameIndex);
            }
        }
        catch (NumberFormatException e)
        {
            $qualityscroll_cover_jacov_probe_6e48e9d38d698afe(109);throw new ErrorMessage("Invalid file format: " + file);
        }
        catch (FileNotFoundException e)
        {
            $qualityscroll_cover_jacov_probe_6e48e9d38d698afe(110);throw new ErrorMessage(e.getMessage());
        }
        catch (IOException e)
        {
            $qualityscroll_cover_jacov_probe_6e48e9d38d698afe(111);throw new ErrorMessage("Read error: " + file);
        }
        $qualityscroll_cover_jacov_probe_6e48e9d38d698afe(104);return table;
    }
}
