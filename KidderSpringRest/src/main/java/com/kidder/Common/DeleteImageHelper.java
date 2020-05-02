package com.kidder.Common;

import java.io.File;

public class DeleteImageHelper {
	 public static void delete(File file) {
	        boolean success = false;
	        if (file.isDirectory()) {
	            for (File deleteMe: file.listFiles()) {
	                // recursive delete
	                delete(deleteMe);
	            }
	        }
	        success = file.delete();
	        if (success) {
	            System.out.println(file.getAbsoluteFile() + " Deleted");
	        } else {
	            System.out.println(file.getAbsoluteFile() + " Deletion failed!!!");
	        }
	    }
}


