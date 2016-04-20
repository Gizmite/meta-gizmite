# Copyright (C) 2012-2015 O.S. Systems Software LTDA.
# Released under the MIT license (see COPYING.MIT for the terms)

SUMMARY = "FSL Community BSP Linux mainline based kernel with backported features and fixes"
DESCRIPTION = "Linux kernel based on mainline kernel used by FSL Community BSP in order to \
provide support for some backported features and fixes, or because it was applied in linux-next \
and takes some time to become part of a stable version, or because it is not applicable for \
upstreaming."

include linux-fslc.inc

PV = "4.1+git${SRCPV}"

SRCBRANCH = "master"
SRCREV = "9a0e3eea25d3ab267aff9d4eaed83fbe46d989d0"

SRC_URI += " \
	file://0001-Add-hardware-support-for-Gizmite-iMX6-DualLite-board.patch \
	file://0002-Add-changes-originally-staged-by-xxx-for-Si114x-ALS-.patch \
	file://0003-Add-device-tree-binding.patch \
	file://0004-add-flexcan.patch \
	file://0005-Fix-bug-in-clock-tree-preventing-CAN-from-coming-up.patch \
	file://0006-Remove-TI_ST-nodes-in-favour-of-using-HCI_UART-firmw.patch \
"
COMPATIBLE_MACHINE = "(mxs|mx5|mx6|vf)"
