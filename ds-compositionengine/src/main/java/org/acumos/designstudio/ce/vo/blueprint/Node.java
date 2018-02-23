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

package org.acumos.designstudio.ce.vo.blueprint;

import java.io.Serializable;
import java.util.List;

public class Node implements Serializable {

	private static final long serialVersionUID = -6799798022353553155L;
	
	private String container_name;
	private String node_type;
	private String image;
	private String proto_uri;
	private List<OperationSignatureList> operation_signature_list;
	private String script;

	
	/**
	 * @return the container_name
	 */
	public String getContainer_name() {
		return container_name;
	}

	/**
	 * @param container_name the container_name to set
	 */
	public void setContainer_name(String container_name) {
		this.container_name = container_name;
	}

	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}

	/**
	 * @param image
	 *            the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}

	/**
	 * @return the node_type
	 */
	public String getNode_type() {
		return node_type;
	}

	/**
	 * @param node_type the node_type to set
	 */
	public void setNode_type(String node_type) {
		this.node_type = node_type;
	}

	/**
	 * @return the proto_uri
	 */
	public String getProto_uri() {
		return proto_uri;
	}

	/**
	 * @param proto_uri the proto_uri to set
	 */
	public void setProto_uri(String proto_uri) {
		this.proto_uri = proto_uri;
	}

	/**
	 * @return the operation_signature_list
	 */
	public List<OperationSignatureList> getOperation_signature_list() {
		return operation_signature_list;
	}

	/**
	 * @param operation_signature_list the operation_signature_list to set
	 */
	public void setOperation_signature_list(List<OperationSignatureList> operation_signature_list) {
		this.operation_signature_list = operation_signature_list;
	}

	/**
	 * @return the script
	 */
	public String getScript() {
		return script;
	}

	/**
	 * @param script the script to set
	 */
	public void setScript(String script) {
		this.script = script;
	}

}
