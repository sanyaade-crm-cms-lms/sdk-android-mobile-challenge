package com.anypresence.anypresence_inc.citi_mobile_challenge.dao;

// THIS CODE IS GENERATED BY greenDAO, EDIT ONLY INSIDE THE "KEEP"-SECTIONS

// KEEP INCLUDES - put your custom includes here
// KEEP INCLUDES END
/**
 * Entity mapped to table APCACHED_REQUEST.
 */
public class APCachedRequest {

	private Long id;
	private String scope;
	private String type;
	private String parameter;
	private java.util.Date _cacheUpdatedAt;

	// KEEP FIELDS - put your custom fields here
	// KEEP FIELDS END

	public APCachedRequest() {
	}

	public APCachedRequest(Long id) {
		this.id = id;
	}

	public APCachedRequest(Long id, String scope, String type,
			String parameter, java.util.Date _cacheUpdatedAt) {
		this.id = id;
		this.scope = scope;
		this.type = type;
		this.parameter = parameter;
		this._cacheUpdatedAt = _cacheUpdatedAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getParameter() {
		return parameter;
	}

	public void setParameter(String parameter) {
		this.parameter = parameter;
	}

	public java.util.Date get_cacheUpdatedAt() {
		return _cacheUpdatedAt;
	}

	public void set_cacheUpdatedAt(java.util.Date _cacheUpdatedAt) {
		this._cacheUpdatedAt = _cacheUpdatedAt;
	}

	// KEEP METHODS - put your custom methods here
	// KEEP METHODS END

}
