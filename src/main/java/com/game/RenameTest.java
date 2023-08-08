package com.game;

import java.io.File;

public class RenameTest {

	public static void main(String[] args) {
		String rootPath =  "/Users/gimjeonghun/Documents/dev/works/html/img";
		String targetPath = "/Users/gimjeonghun/Documents/dev/works/html/img/cards";
		File rootFile = new File(rootPath);
		File[] dirs = rootFile.listFiles();
		for(File dir : dirs) {
			if(dir.isDirectory()) {
				File[] files = dir.listFiles();
				for(File file : files) {
					String name = file.getName();
					System.out.println(name);
				}
			}
		}
	}
}
