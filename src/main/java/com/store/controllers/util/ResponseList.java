package com.store.controllers.util;

import java.util.ArrayList;
import java.util.List;

public class ResponseList<T> {

		private List<?> data;
		private List<String> errors;

		public ResponseList() {
		}

		public List<String> getErrors() {
			if (this.errors == null) {
				this.errors = new ArrayList<String>();
			}
			return errors;
		}

		public void setErrors(List<String> errors) {
			this.errors = errors;
		}
		
	    public List<?> getData() {
	    	return data;
	    }
		  
	    public void setData(List<?> data) {
	    	this.data = data;
	    }

}
