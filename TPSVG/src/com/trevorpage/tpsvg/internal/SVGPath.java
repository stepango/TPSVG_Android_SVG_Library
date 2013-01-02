package com.trevorpage.tpsvg.internal;

import android.graphics.Matrix;
import android.graphics.Path;

/**
 * A subclass of android.graphics.Path that allows for some custom properties. 
 *
 */
public class SVGPath extends Path {

	private boolean mAnchorRight;
	private boolean mAnchorBottom;
	private boolean mStretchToRemainderWidth;
	private boolean mStretchToRemainderHeight;
	
	public SVGPath() {
		super();
		init();
	}
	
	public SVGPath (Path src) {
		super(src);
		init();
	}
	
	private void init() {
		mAnchorRight = false;
		mAnchorBottom = false;
		mStretchToRemainderWidth = false;
		mStretchToRemainderHeight = false;
	}
	
	public void rewind() {
		super.rewind();
		init();
	}

	public void reset() {
		super.reset();
		init();
	}
	
	public void addPath(Path src) {
		super.addPath(src);
		copyCustomAttributes(src);
	}

	public void addPath(Path src, Matrix matrix) {
		super.addPath(src);
		copyCustomAttributes(src);
	}
	
	public void addPath(Path src, float dx, float dy) {
		super.addPath(src, dx, dy);
		copyCustomAttributes(src);
	}
	
	public void setAnchorRight(boolean anchor) {
		mAnchorRight = anchor;
	}
	
	public boolean getAnchorRight() {
		return mAnchorRight;
	}
	
	public void setAnchorBottom(boolean anchor) {
		mAnchorBottom = anchor;
	}
	
	public boolean getAnchorBottom() {
		return mAnchorBottom;
	}
	
	public boolean usesRemainderWidthOrHeight() {
		return mAnchorBottom || mAnchorRight || mStretchToRemainderWidth || mStretchToRemainderHeight;
	}
	
	public void setStretchToRemainderWidth(boolean stretch) {
		mStretchToRemainderWidth = stretch;
	}
	
	public boolean getStretchToRemainderWidth() {
		return mStretchToRemainderWidth;
	}

	public void setStretchToRemainderHeight(boolean stretch) {
		mStretchToRemainderHeight = stretch;
	}
	
	public boolean getStretchToRemainderHeight() {
		return mStretchToRemainderHeight;
	}
	
	private void copyCustomAttributes(Path src) {
		if (src instanceof SVGPath) {
			if (((SVGPath)src).getAnchorBottom()) {
				setAnchorBottom(true);
			}
			if (((SVGPath)src).getAnchorRight()) {
				setAnchorRight(true);
			}
			if (((SVGPath)src).getStretchToRemainderWidth()) {
				setStretchToRemainderWidth(true);
			}
			if (((SVGPath)src).getStretchToRemainderHeight()) {
				setStretchToRemainderHeight(true);
			}
		}
	}
}
