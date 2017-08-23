package org.eclipse.dirigible.engine.js.rhino.service;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.dirigible.commons.api.scripting.ScriptingDependencyException;
import org.eclipse.dirigible.commons.api.service.IRestService;
import org.eclipse.dirigible.engine.js.rhino.processor.RhinoJavascriptEngineProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;

/**
 * Front facing REST service serving the Mozilla Rhino based Javascript backend services
 */
@Singleton
@Path("/rhino")
@Api(value = "JavaScript Engine - Rhino", authorizations = { @Authorization(value = "basicAuth", scopes = {}) })
@ApiResponses({ @ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden") })
public class RhinoJavascriptEngineRestService implements IRestService {

	private static final Logger logger = LoggerFactory.getLogger(RhinoJavascriptEngineRestService.class.getCanonicalName());

	@Inject
	private RhinoJavascriptEngineProcessor processor;

	/**
	 * @param path
	 * @param request
	 * @return resource content
	 */
	@GET
	@Path("/{path:.*}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation("Execute Server Side JavaScript Rhino Resource")
	@ApiResponses({ @ApiResponse(code = 200, message = "Execution Result") })
	public Response getResource(@PathParam("path") String path, @Context HttpServletRequest request, @Context HttpServletResponse response) {
		try {
			processor.executeService(path);
			return Response.ok().build();
		} catch (ScriptingDependencyException e) {
			logger.error(e.getMessage(), e);
			return Response.status(Response.Status.ACCEPTED).entity(e.getMessage()).build();
		} catch (Throwable e) {
			logger.error(e.getMessage(), e);
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
	}

	@Override
	public Class<? extends IRestService> getType() {
		return RhinoJavascriptEngineRestService.class;
	}
}