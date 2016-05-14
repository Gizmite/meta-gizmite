require ${BPN}.inc

DEFAULT_PREFERENCE = "-1"

SRCREV = "407430fcddf96008725b2fe4a04d7aff6da6da50"
PV = "11.1+git${SRCPV}"

SRC_URI = "git://github.com/etnaviv/mesa.git;branch=master"

S = "${WORKDIR}/git"

DEPENDS += "python-mako-native"

inherit pythonnative

#because we cannot rely on the fact that all apps will use pkgconfig,
#make eglplatform.h independent of MESA_EGL_NO_X11_HEADER
do_install_append() {
    if ${@bb.utils.contains('PACKAGECONFIG', 'egl', 'true', 'false', d)}; then
        sed -i -e 's/^#if defined(MESA_EGL_NO_X11_HEADERS)$/#if defined(MESA_EGL_NO_X11_HEADERS) || ${@bb.utils.contains('PACKAGECONFIG', 'x11', '0', '1', d)}/' ${D}${includedir}/EGL/eglplatform.h
    fi
}
