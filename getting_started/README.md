Getting Started
---------------

### create a new app

* assumes having installed the [sdk](http://developer.android.com/sdk/index.html) and put `adb` into PATH

```bash

    $ cd getting_started

    $ android list targets   # looking for 4.0.3 (ice cream sand witch)

            ----------
            id: 8 or "android-15"
             Name: Android 4.0.3
             Type: Platform
             API level: 15
             Revision: 3
             Skins: HVGA, QVGA, WQVGA400, WQVGA432, WSVGA, WVGA800 (default), WVGA854, WXGA720, WXGA800
             ABIs : no ABIs.
            ----------

    $ android create project --target 8 --name App1 --path . --package nomilous.app1 --activity MainActivity

    $ cp local.properties local.properties.tmpl   # no! shows my homedir

    $ echo local.properties >> .gitignore

    $ android update project --path .  # rebuild with gitignored local.properties

```

### build debug version, installing and running it

* assumes the phone/tablet is attached by usb
* assumes java ant build system is in PATH

```bash 

    $ ant debug      # compile
    $ ant installd   # install


    #
    # start the activity 
    #

    $ adb shell am start -n nomilous.app1/.MainActivity

```

