require xorg-driver-video.inc

SUMMARY = "X.Org graphics driver for KMS systems with pluggable GPU backends"
DESCRIPTION = "The xf86-video-armada module is a 2D graphics driver for the X Window \
system as implemented by X.org."

LICENSE = "MIT-X"
LIC_FILES_CHKSUM = "file://src/armada_drm.c;beginline=1;endline=6;md5=dccd8d7cf3376522562dda2b67b40130"

DEPENDS += "libdrm-armada"

SRCREV = "05bc938199b236616451f9792e098181e80b078f"
BRANCH = "novena-r2"
PV = "0.0.0+gitr${SRCPV}"

SRC_URI = "git://github.com/xobs/xserver-xorg-video-armada.git;branch=${BRANCH}"
S = "${WORKDIR}/git"
