package com.nostra13.universalimageloader.core.assist;

import java.io.File;

import com.nostra13.universalimageloader.cache.disc.DiscCacheAware;

/**
 * Utility for convenient work with disc cache.<br />
 * <b>NOTE:</b> This utility works with file system so avoid using it on application main thread.
 * 
 * @author Sergey Tarasevich (nostra13[at]gmail[dot]com)
 */
public final class DiscCacheUtil {

	private DiscCacheUtil() {
	}

	/** Returns {@link File} of cached image or <b>null</b> if image was not cached in disc cache */
	public static File findInCache(String imageUri, DiscCacheAware discCache) {
		File image = discCache.get(imageUri);
		return image.exists() ? image : null;
	}

	/**
	 * Removed cached image file from disc cache (if image was cached in disc cache before)
	 * 
	 * @return <b>true</b> - if cached image file existed and was deleted; <b>false</b> - otherwise.
	 */
	public static boolean removeFromCache(String imageUri, DiscCacheAware discCache) {
		File image = discCache.get(imageUri);
		return image.delete();
	}
}
