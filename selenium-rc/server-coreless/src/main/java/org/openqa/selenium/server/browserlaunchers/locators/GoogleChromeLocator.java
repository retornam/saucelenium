/*
 * Copyright 2008 Google, Inc.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */

package org.openqa.selenium.server.browserlaunchers.locators;

import java.io.IOException;

import org.openqa.selenium.server.browserlaunchers.GoogleChromeLauncher;
import org.openqa.selenium.server.browserlaunchers.MacProxyManager;
import org.openqa.selenium.server.browserlaunchers.WindowsProxyManager;
import org.openqa.selenium.server.browserlaunchers.WindowsUtils;

/**
 * Discovers a valid Google Chrome installation on local system.
 */
public class GoogleChromeLocator extends SingleBrowserLocator {

	// TODO: Support Ubuntu when I know where it installs googlechrome
	
	protected String browserName() {
		return "Google Chrome";
	}

	protected String seleniumBrowserName() {
		return "googlechrome";
	}

	protected String[] standardlauncherFilenames() {
		if (WindowsUtils.thisIsWindows()) {
            return new String[]{"chrome.exe"};
        } else {
            return new String[]{"Google Chrome"};
        }
    }

	protected String browserPathOverridePropertyName() {
		return "googleChromeDefaultPath";
	}

	protected String[] usualLauncherLocations() {
		return WindowsUtils.thisIsWindows() ? new String[] { WindowsUtils.getLocalAppDataPath() + "\\Google\\Chrome\\Application" } : new String[] { "/Applications/Google Chrome.app/Contents/MacOS" };
	}

}
