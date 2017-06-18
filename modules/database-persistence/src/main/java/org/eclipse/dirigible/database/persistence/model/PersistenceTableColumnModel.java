/*******************************************************************************
 * Copyright (c) 2016 SAP and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * SAP - initial API and implementation
 *******************************************************************************/

package org.eclipse.dirigible.database.persistence.model;

/**
 * The column element of the persistence model
 */
public class PersistenceTableColumnModel {

	private String field;
	private String name;
	private String type;
	private int length;
	private boolean nullable;
	private boolean primaryKey;
	private int precision;
	private int scale;
	private boolean generated;

	/**
	 * The constructor from the fields
	 *
	 * @param field
	 *            the field
	 * @param name
	 *            the name
	 * @param type
	 *            the type
	 * @param length
	 *            the length
	 * @param notNull
	 *            whether null values are allowed
	 * @param primaryKey
	 *            whether it is a primary key
	 * @param precision
	 *            the precision for floating point values
	 * @param scale
	 *            the scale for floating point values
	 */
	public PersistenceTableColumnModel(String field, String name, String type, int length, 
			boolean nullable, boolean primaryKey, int precision, int scale, boolean generated) {
		this.field = field;
		this.name = name;
		this.type = type;
		this.length = length;
		this.nullable = nullable;
		this.primaryKey = primaryKey;
		this.precision = precision;
		this.scale = scale;
		this.generated = generated;
	}


	/**
	 * Getter for the field
	 *
	 * @return the field
	 */
	public String getField() {
		return field;
	}

	/**
	 * Setter for the field
	 *
	 * @param field
	 *            the field
	 */
	public void setField(String field) {
		this.field = field;
	}
	
	/**
	 * Getter for the name
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter for the name
	 *
	 * @param name
	 *            the name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Getter for the type
	 *
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * Setter for the type
	 *
	 * @param type
	 *            the type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Getter for the length
	 *
	 * @return the length
	 */
	public int getLength() {
		return length;
	}

	/**
	 * Setter for the length
	 *
	 * @param length
	 *            the length
	 */
	public void setLength(int length) {
		this.length = length;
	}

	/**
	 * Check for nullable
	 *
	 * @return true if can be null
	 */
	public boolean isNullable() {
		return nullable;
	}

	/**
	 * Setter for the nullable
	 *
	 * @param nullable
	 *            whether null values are allowed
	 */
	public void setNullable(boolean nullable) {
		this.nullable = nullable;
	}
	
	/**
	 * Check for primary key
	 *
	 * @return true if primary key
	 */
	public boolean isPrimaryKey() {
		return primaryKey;
	}

	/**
	 * Setter for the primary key
	 *
	 * @param primaryKey
	 *            whether it is a primary key
	 */
	public void setPrimaryKey(boolean primaryKey) {
		this.primaryKey = primaryKey;
	}

	/**
	 * Getter for the precision
	 *
	 * @return the precision
	 */
	public int getPrecision() {
		return precision;
	}

	/**
	 * Setter for the precision
	 *
	 * @param precision
	 *            the precision
	 */
	public void setPrecision(int precision) {
		this.precision = precision;
	}
	
	/**
	 * Getter for the scale
	 *
	 * @return the scale
	 */
	public int getScale() {
		return scale;
	}

	/**
	 * Setter for the scale
	 *
	 * @param scale
	 *            the scale
	 */
	public void setScale(int scale) {
		this.scale = scale;
	}
	

	/**
	 * Check whether it is a generated value
	 *
	 * @return true if generated
	 */
	public boolean isGenerated() {
		return generated;
	}

	/**
	 * Setter for the generated
	 *
	 * @param generrated
	 *            whether it is a generated
	 */
	public void setGenerated(boolean generated) {
		this.generated = generated;
	}

}