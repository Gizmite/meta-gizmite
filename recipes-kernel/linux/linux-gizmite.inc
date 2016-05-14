# Copyright (C) 2012-2015 O.S. Systems Software LTDA.
# Released under the MIT license (see COPYING.MIT for the terms)

require recipes-kernel/linux/linux-imx.inc

DEPENDS += "lzop-native bc-native"

SRC_URI = "git://github.com/torvalds/linux;branch=${SRCBRANCH} \
           file://defconfig"
LOCALVERSION = "-gizmite"
SCMVERSION ?="y"
SRCBRANCH ?=""

S = "${WORKDIR}/git"

KERNEL_EXTRA_ARGS += "LOADADDR=${UBOOT_ENTRYPOINT}"
