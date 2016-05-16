require xorg-driver-video.inc

SUMMARY = "X.Org graphics driver for KMS systems with pluggable GPU backends"
DESCRIPTION = "The xf86-video-armada module is a 2D graphics driver for the X Window \
system as implemented by X.org."

LICENSE = "MIT"

DEPENDS += "libdrm_armada"

SRCREV = "05bc938199b236616451f9792e098181e80b078f"
PV = "0.0.0+gitr${SRCPV}"

SRC_URI = "https://github.com/xobs/xserver-xorg-video-armada.git \
	   file://"

S = "${WORKDIR}/git"
