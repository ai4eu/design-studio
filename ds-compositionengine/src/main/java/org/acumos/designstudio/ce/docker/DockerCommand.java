/*-
 * ===============LICENSE_START=======================================================
 * Acumos
 * ===================================================================================
 * Copyright (C) 2017 AT&T Intellectual
 * 						Property & Tech
 * 						Mahindra. All rights reserved.
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

package org.acumos.designstudio.ce.docker;

import org.acumos.designstudio.ce.util.EELFLoggerDelegator;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.exception.DockerException;

/**
 * Parent class of all Docker commands.
 */
public abstract class DockerCommand
{
	// logger 
		public static final EELFLoggerDelegator logger = EELFLoggerDelegator.getLogger(DockerCommand.class);
		
	protected DockerClient client;

	public abstract void execute() throws DockerException;

	public abstract String getDisplayName();

	public DockerClient getClient()
	{
		return client;
	}

	public void setClient(DockerClient dockerClient)
	{
		this.client = dockerClient;
	}
}