/* $$43564A43$$ WARNING: Do not edit. $$ This file has been instrumented by qualityscroll_cover_jacov 4.0.4-SNAPSHOT (Instrument Date:20240229123823) $$ */package net.sf.gogui.tm;

public final class TMTest {
	public static transient boolean[] $qualityscroll_cover_coverage_buffer = $qualityscroll_cover_coverage_buffer_init();public static boolean[] $qualityscroll_cover_coverage_buffer_init() {try{if($qualityscroll_cover_coverage_buffer != null){return $qualityscroll_cover_coverage_buffer;}java.lang.Class<?> thisClass = TMTest.class.getClassLoader().loadClass("com.qualityscroll.cover.runtime.ProbeStore");java.lang.reflect.Method getProbesMethod = thisClass.getMethod("getProbes", long.class, long.class, long.class, java.lang.String.class, int.class);$qualityscroll_cover_coverage_buffer = (boolean[]) getProbesMethod.invoke(null,/* key(tuId + timestamp) */ -425486052823281690L,/* translation unit id   */ 6182494295699154931L,/* timestamp             */ 1709177903105L,/* source file name      */ "TMTest.java",/* probe size            */ 2);}catch(java.lang.Exception e){throw new java.lang.RuntimeException(e);}return $qualityscroll_cover_coverage_buffer;}private static boolean $qualityscroll_cover_jacov_probe_55cca1ce4106e7f3(int index) {$qualityscroll_cover_coverage_buffer[index] = true;return true;}private static String TEST = "TEST";
	public TMTest(){$qualityscroll_cover_coverage_buffer_init();
		$qualityscroll_cover_jacov_probe_55cca1ce4106e7f3(0);System.out.println(TEST);
	}
	
	public static void main(String[] args) {$qualityscroll_cover_coverage_buffer_init();
		$qualityscroll_cover_jacov_probe_55cca1ce4106e7f3(1);TMTest tmTest = new TMTest();
		System.out.println(tmTest.toString());
	}
}
