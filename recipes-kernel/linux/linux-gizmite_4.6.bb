# Copyright (C) 2012-2015 O.S. Systems Software LTDA.
# Released under the MIT license (see COPYING.MIT for the terms)

SUMMARY = "Mainline Linux Kernel"
DESCRIPTION = "Mainline Linux Kernel used as the base for Gizmite project hardware. \
This package includes patches that can be applied to 4.6.x kernels for full Gizmite support. \
"

include linux-gizmite.inc

PV = "4.6+git${SRCPV}"

SRC_URI += " \
	file://0001-Add-hardware-support-for-Gizmite-iMX6-DualLite-board.patch \
	file://0002-Add-changes-originally-staged-by-xxx-for-Si114x-ALS-.patch \
	file://0003-Add-device-tree-binding.patch \
	file://0004-add-flexcan.patch \
	file://0005-Fix-bug-in-clock-tree-preventing-CAN-from-coming-up.patch \
	file://0006-Remove-TI_ST-nodes-in-favour-of-using-HCI_UART-firmw.patch \
"
COMPATIBLE_MACHINE = "(mx6)"
