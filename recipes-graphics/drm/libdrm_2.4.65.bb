SUMMARY = "Userspace interface to the kernel DRM services"
DESCRIPTION = "The runtime library for accessing the kernel DRM services.  DRM \
stands for \"Direct Rendering Manager\", which is the kernel portion of the \
\"Direct Rendering Infrastructure\" (DRI).  DRI is required for many hardware \
accelerated OpenGL drivers."
HOMEPAGE = "http://dri.freedesktop.org"
SECTION = "x11/base"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://xf86drm.c;beginline=9;endline=32;md5=c8a3b961af7667c530816761e949dc71"
PROVIDES = "drm libdrm"
DEPENDS = "libpthread-stubs udev libpciaccess"

SRC_URI = "git://github.com/austriancoder/libdrm.git"

inherit autotools pkgconfig

EXTRA_OECONF += "--disable-cairo-tests \
                 --enable-etnaviv-experimental-api \
                 --enable-install-test-programs \
                 --disable-manpages \
                 --disable-valgrind \
                "

ALLOW_EMPTY_${PN}-drivers = "1"
PACKAGES =+ "${PN}-tests ${PN}-drivers ${PN}-etnaviv"

RRECOMMENDS_${PN}-drivers = "${PN}-etnaviv"

FILES_${PN}-tests = "${bindir}/dr* ${bindir}/mode* ${bindir}/*test"
FILES_${PN}-etnaviv = "${libdir}/libdrm_etnaviv.so.*"

