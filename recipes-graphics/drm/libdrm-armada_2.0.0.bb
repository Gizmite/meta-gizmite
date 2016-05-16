SUMMARY = "Userspace interface to the kernel DRM services"
DESCRIPTION = "The runtime library for accessing the kernel DRM services.  DRM \
stands for \"Direct Rendering Manager\", which is the kernel portion of the \
\"Direct Rendering Infrastructure\" (DRI).  DRI is required for many hardware \
accelerated OpenGL drivers."
HOMEPAGE = "http://dri.freedesktop.org"
SECTION = "x11/base"
LICENSE = "GPLv2"
PROVIDES = "libdrm-armada"
DEPENDS = "libdrm"

SRCREV = "6b461c163b0bd02c76b65d94cc2fb3767167bda8"
SRC_URI = "git://ftp.arm.linux.org.uk/~rmk/libdrm-armada.git"

inherit autotools pkgconfig

PACKAGES =+ "${PN}-armada"

FILES_${PN}-armada = "${libdir}/libdrm_armada.so.*"

