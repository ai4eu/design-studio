/*-
 * ===============LICENSE_START=======================================================
 * Acumos
 * ===================================================================================
 * Copyright (C) 2017 AT&T Intellectual Property & Tech Mahindra. All rights reserved.
 * ===================================================================================
 * This Acumos software file is distributed by AT&T and Tech Mahindra
 * under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *      http://www.apache.org/licenses/LICENSE-2.0
 *  
 * This file is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ===============LICENSE_END=========================================================
 */

/**
 * 
 */
package org.acumos.designstudio.ce.vo.cdump;

import java.io.Serializable;

public class ReqCapability implements Serializable{
	private static final long serialVersionUID = -1215951868789856113L;
	
	private String id;
	boolean stream;
	private Message[] name;
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public Message[] getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(Message[] name) {
		this.name = name;
	}

	@Override
	public String toString() {
		if (name.length > 0)
			return "ReqCapability["+this.id+",stream="+stream+",name="+name[0].toString()+"]";
		else
			return "ReqCapability["+this.id+",stream="+stream+",name=<empty>]";

	}
	
}
