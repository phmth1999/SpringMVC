package com.springmvc.Utils;

import org.apache.log4j.Logger;

public class Convert {
	final static Logger logger = Logger.getLogger(Convert.class);
	public static int convertCategoryToInt(String name) throws Exception{
		int res = 0;
		try {
			if(name.equals("Men's")){
				res = 1;
			}else if(name.equals("Women's")){
				res = 2;
			}else if(name.equals("Kid's")){
				res = 3;
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return res;
	}
	public static int convertBrandToInt(String name) throws Exception{
		int res = 0;
		try {
			if(name.equals("Adidas")){
				res = 1;
			}else if(name.equals("Nike")){
				res = 2;
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return res;
	}
}

