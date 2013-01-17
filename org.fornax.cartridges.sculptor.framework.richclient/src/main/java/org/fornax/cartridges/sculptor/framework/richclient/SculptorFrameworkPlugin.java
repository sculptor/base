/*
 * Copyright 2009 The Fornax Project Team, including the original 
 * author or authors.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.fornax.cartridges.sculptor.framework.richclient;

import java.util.HashMap;
import java.util.Iterator;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class SculptorFrameworkPlugin extends AbstractUIPlugin {

    // The plug-in ID
    public static final String PLUGIN_ID = "org.fornax.cartridges.sculptor.framework.richclient";
    
    public static final String ICONS_PATH = "icons/";
    
    public static final ImageDescriptor TABLE_CHOOSE_COL_IMAGE = getImageDescriptor(ICONS_PATH + "table_choose_col.gif");
    public static final ImageDescriptor TABLE_ADJUST_IMAGE = getImageDescriptor(ICONS_PATH + "table_adjust.gif");
    
    // The shared instance
    private static SculptorFrameworkPlugin plugin;

    private static ImageRegistry imageRegistry;

    private static HashMap<String, Color> colors;

    /**
     * The constructor
     */
    public SculptorFrameworkPlugin() {
    }

    /*
     * (non-Javadoc)
     * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
     */
    @Override
    public void start(BundleContext context) throws Exception {
        super.start(context);
        plugin = this;
    }

    /*
     * (non-Javadoc)
     * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
     */
    @Override
    public void stop(BundleContext context) throws Exception {
        plugin = null;
        if (colors != null) {
            Iterator<Color> iter = colors.values().iterator();
            while (iter.hasNext()) {
                iter.next().dispose();
            }
        }
        super.stop(context);
    }

    /**
     * Returns the shared instance
     *
     * @return the shared instance
     */
    public static SculptorFrameworkPlugin getDefault() {
        return plugin;
    }

    public static Color getColor(int red, int green, int blue) {
        if (colors == null) {
            colors = new HashMap<String, Color>();
        }

        String colorCode = red + "," + green + "," + blue;
        Color color = colors.get(colorCode);
        if (color == null) {
            color = new Color(Display.getDefault(), red, green, blue);
            colors.put(colorCode, color);
        }

        return color;
    }


    public static Image getImage(String path) {
        return getImage(PLUGIN_ID, path);
    }

    public static Image getImage(String pluginId, String path) {
        if (imageRegistry == null) {
            imageRegistry = new ImageRegistry(Display.getDefault());
        }

        Image image = imageRegistry.get(path);
        if (image == null) {

            image = imageDescriptorFromPlugin(pluginId, path).createImage();
            imageRegistry.put(path, image);
        }
        return image;
    }



    public static ImageDescriptor getImageDescriptor(String pPath) {
        if (imageRegistry == null) {
            imageRegistry = new ImageRegistry(Display.getDefault());
        }

        ImageDescriptor tImageDescriptor = imageRegistry.getDescriptor(pPath);
        if (tImageDescriptor == null) {
            tImageDescriptor =  imageDescriptorFromPlugin(PLUGIN_ID, pPath);
            imageRegistry.put(pPath, tImageDescriptor);
        }
        return tImageDescriptor;
    }
}
