	package com.infy.app.util;
	
	import java.awt.Toolkit;
	import java.awt.datatransfer.Clipboard;
	import java.awt.datatransfer.StringSelection;
	
	public class AppUtil {
		
		
		public static void copyPathIntoClipBoard(String filePath){
			StringSelection selection = new StringSelection(filePath);
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			clipboard.setContents(selection, selection);
		}

		
	}
