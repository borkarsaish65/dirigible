/*******************************************************************************
 * Copyright (c) 2015 SAP and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * SAP - initial API and implementation
 *******************************************************************************/

package org.eclipse.dirigible.repository.api;

import java.util.Map;

public class RepositoryFactory {

	/**
	 * Create a Repository instance used for local operations
	 *
	 * @param parameters
	 * @return local repository
	 * @throws RepositoryCreationException
	 */
	public static IRepository createRepository(Map<String, Object> parameters) throws RepositoryCreationException {
		if (isOSGiEnvironment()) {
			return RepositoryFactoryOSGi.createRepository(parameters);
		}
		return RepositoryFactoryNonOSGi.createRepository(parameters);
	}

	/**
	 * Create a Master Repository from which the content can be synchronized as initial load or reset
	 *
	 * @param parameters
	 * @return master repository
	 * @throws RepositoryCreationException
	 */
	public static IMasterRepository createMasterRepository(Map<String, Object> parameters) throws RepositoryCreationException {
		if (isOSGiEnvironment()) {
			return RepositoryFactoryOSGi.createMasterRepository(parameters);
		}
		return RepositoryFactoryNonOSGi.createMasterRepository(parameters);
	}

	public static boolean isOSGiEnvironment() {
		return Boolean.parseBoolean(System.getProperty(ICommonConstants.INIT_PARAM_RUN_ON_OSGI));
	}

}