package org.ofbiz.ignite.services;

import java.util.Locale;
import java.util.Map;
import java.util.Set;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.ofbiz.base.util.UtilProperties;
import org.ofbiz.base.util.UtilValidate;
import org.ofbiz.ignite.container.IgniteClientContainer;
import org.ofbiz.service.DispatchContext;
import org.ofbiz.service.ServiceUtil;

public class CacheService {
	public static final String module = CacheService.class.getName();
	private static final String resource = "IgniteclientUiLabels";

	/**
	 * 向缓存添加数据
	 * 
	 * @param dctx
	 * @param context
	 * @return
	 */
	public static Map<String, Object> put(DispatchContext dctx, Map<String, Object> context) {
		// Delegator delegator = dctx.getDelegator();
		// LocalDispatcher dispatcher = dctx.getDispatcher();
		Locale locale = (Locale) context.get("locale");
		Map<String, Object> result = ServiceUtil.returnSuccess();
		try {
			String cacheName = (String) context.get("cacheName");
			if(UtilValidate.isEmpty(cacheName)){
				cacheName= CacheService.class.getSimpleName();
			}
			Object key = context.get("cacheKey");
			Object value = context.get("cacheValue");

			Ignite ignite = IgniteClientContainer.getIgnite();
			if (ignite != null && UtilValidate.isNotEmpty(key)) {
				IgniteCache cache = ignite.getOrCreateCache(cacheName);
				cache.put(key, value);
				result.put("result", Boolean.TRUE);
			} else {
				result.put("result", Boolean.FALSE);
			}

		} catch (Exception e) {
			String errMsg = UtilProperties.getMessage(resource, e.getMessage(), locale);
			return ServiceUtil.returnError(errMsg);
		}
		return result;
	}

	/**
	 * 取缓存中的数据
	 * 
	 * @param dctx
	 * @param context
	 * @return
	 */
	public static Map<String, Object> get(DispatchContext dctx, Map<String, Object> context) {
		Locale locale = (Locale) context.get("locale");
		Map<String, Object> result = ServiceUtil.returnSuccess();
		try {
			String cacheName = (String) context.get("cacheName");

			Object key = context.get("key");
			Object value = context.get("value");

			Ignite ignite = IgniteClientContainer.getIgnite();
			if (ignite != null && UtilValidate.isNotEmpty(key)) {
				IgniteCache cache = ignite.getOrCreateCache(cacheName);
				Object obj = cache.get(key);
				result.put("result", obj);
			} else {
				result.put("result", null);
			}

		} catch (Exception e) {
			String errMsg = UtilProperties.getMessage(resource, e.getMessage(), locale);
			return ServiceUtil.returnError(errMsg);
		}
		return result;
	}

	
	/**
	 * 向缓存添加多个数据
	 * 
	 * @param dctx
	 * @param context
	 * @return
	 */
	public static Map<String, Object> putAll(DispatchContext dctx, Map<String, Object> context) {
		 
		Locale locale = (Locale) context.get("locale");
		Map<String, Object> result = ServiceUtil.returnSuccess();
		try {
			String cacheName = (String) context.get("cacheName");
			if(UtilValidate.isEmpty(cacheName)){
				cacheName= CacheService.class.getSimpleName();
			}
			Map batch =(Map) context.get("batchCache");

			Ignite ignite = IgniteClientContainer.getIgnite();
			if (ignite != null && UtilValidate.isNotEmpty(batch)) {
				IgniteCache cache = ignite.getOrCreateCache(cacheName);
				cache.putAll(batch);
				result.put("result", Boolean.TRUE);
			} else {
				result.put("result", Boolean.FALSE);
			}

		} catch (Exception e) {
			String errMsg = UtilProperties.getMessage(resource, e.getMessage(), locale);
			return ServiceUtil.returnError(errMsg);
		}
		return result;
	}

	/**
	 * 取缓存中的多个数据
	 * 
	 * @param dctx
	 * @param context
	 * @return
	 */
	public static Map<String, Object> getAll(DispatchContext dctx, Map<String, Object> context) {
		Locale locale = (Locale) context.get("locale");
		Map<String, Object> result = ServiceUtil.returnSuccess();
		try {
			String cacheName = (String) context.get("cacheName");

			Set batch =(Set) context.get("batchKey");

			Ignite ignite = IgniteClientContainer.getIgnite();
			if (ignite != null && UtilValidate.isNotEmpty(batch)) {
				IgniteCache cache = ignite.getOrCreateCache(cacheName);
				Map obj = cache.getAll(batch);
				result.put("result", obj);
			} else {
				result.put("result", null);
			}

		} catch (Exception e) {
			String errMsg = UtilProperties.getMessage(resource, e.getMessage(), locale);
			return ServiceUtil.returnError(errMsg);
		}
		return result;
	}
}
