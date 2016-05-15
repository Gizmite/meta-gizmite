# Copyright (C) 2012-2015 O.S. Systems Software LTDA.
# Released under the MIT license (see COPYING.MIT for the terms)

inherit kernel

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

DEPENDS += "lzop-native bc-native"

SRC_URI = "git://github.com/torvalds/linux;branch=${SRCBRANCH} \
           file://defconfig"
LOCALVERSION = "-gizmite"
SCMVERSION ?="y"
SRCBRANCH ?=""

S = "${WORKDIR}/git"

KERNEL_EXTRA_ARGS += "LOADADDR=${UBOOT_ENTRYPOINT}"
