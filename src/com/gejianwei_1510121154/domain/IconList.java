package com.gejianwei_1510121154.domain;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class IconList {
	public static final String PATH = "/InfoSystem/img/";

	private List<String> iconList;

	public List<String> getIconList() {
		if (this.iconList == null) {
			this.iconList = IconList.initIconList();
		}
		return iconList;
	}

	//Web应用不能访问本地文件
	public static List<String> initIconList() {// 图片路径
		URL path = IconList.class.getResource("/../../img");
		File file = new File(path.getPath());
		List<String> icons = new ArrayList<String>();
		if (file.isDirectory()) {
			File[] files = file.listFiles();
			for (File f : files) {
				if (f.getName().startsWith("head")) {
					icons.add(PATH + f.getName());
				}
			}
		}
		return icons;
	}
}
