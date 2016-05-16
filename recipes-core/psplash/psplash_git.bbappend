# Copyright (C) 2016 Steven Barker.
# Released under the MIT license (see COPYING.MIT for the terms)

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

DEPENDS += "gdk-pixbuf-native"

PRINC = "8"

SRC_URI += "file://psplash-init"

SPLASH_IMAGES = "file://psplash-poky-img.png;outsuffix=default"
