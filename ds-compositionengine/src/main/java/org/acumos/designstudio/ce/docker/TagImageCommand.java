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

package org.acumos.designstudio.ce.docker;

import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.exception.DockerException;
import com.github.dockerjava.api.exception.NotFoundException;

/**
 * This command removes specified Docker image.
 *
 * @see <A HREF=
 *      "https://docs.docker.com/reference/api/docker_remote_api_v1.19/#tag-an-image-into-a-repository">Docker
 *      tag</A>
 */
public class TagImageCommand extends DockerCommand {
	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	private final String image;

	private final String repository;

	private final String tag;

	private final boolean ignoreIfNotFound;

	private final boolean withForce;

	/**
	 * 
	 * @param image
	 *            Image to tag
	 * @param repository
	 *            Docker repository
	 * @param tag
	 *            Tag to use
	 * @param ignoreIfNotFound
	 *            Boolean
	 * @param withForce
	 *            Boolean
	 */
	public TagImageCommand(final String image, final String repository, final String tag,
			final boolean ignoreIfNotFound, final boolean withForce) {
		this.image = image;
		this.repository = repository;
		this.tag = tag;
		this.ignoreIfNotFound = ignoreIfNotFound;
		this.withForce = withForce;
	}

	public String getImage() {
		return image;
	}

	public String getRepository() {
		return repository;
	}

	public String getTag() {
		return tag;
	}

	public boolean getIgnoreIfNotFound() {
		return ignoreIfNotFound;
	}

	public boolean getWithForce() {
		return withForce;
	}

	@Override
	public void execute() throws DockerException {
		// TODO check it when submitting the form
		if (image == null || image.isEmpty()) {
			throw new IllegalArgumentException("Please provide an image name");
		} else if (repository == null || repository.isEmpty()) {
			throw new IllegalArgumentException("Please provide a repository");
		} else if (tag == null || tag.isEmpty()) {
			throw new IllegalArgumentException("Please provide a tag for the image");
		}
		DockerClient client = getClient();
		try {
			logger.debug("start tagging image {0} in {1} as {2}", image, repository, tag);
			client.tagImageCmd(image, repository, tag).withForce(withForce).exec();
			logger.debug("Tagged image {0} in {1} as {2}", image, repository, tag);
		} catch (NotFoundException e) {
			if (!ignoreIfNotFound) {
				logger.error(String.format("image '%s' not found ", image), e);
			} else {
				logger.error(String.format("image '%s' not found, but skipping this error is turned on, let's continue ... ", image), e);
			}
			throw e;
		}
	}

	@Override
	public String getDisplayName() {
		return "Tag image";
	}
}
