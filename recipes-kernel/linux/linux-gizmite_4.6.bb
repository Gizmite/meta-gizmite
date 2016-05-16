# Copyright (C) 2012-2015 O.S. Systems Software LTDA.
# Released under the MIT license (see COPYING.MIT for the terms)

SUMMARY = "Mainline Linux Kernel"
DESCRIPTION = "Mainline Linux Kernel used as the base for Gizmite project hardware. \
This package includes patches that can be applied to 4.6.x kernels for full Gizmite support. \
"

require recipes-kernel/linux/linux-gizmite.inc
require recipes-kernel/linux/linux-dtb.inc

PV = "4.6+git${SRCPV}"

SRCBRANCH = "master"
SRCREV = "1410b74e4061e05a5d2bffb1f99829efce27c8a9"

SRC_URI += " \
	file://0001-Add-hardware-support-for-Gizmite-iMX6-DualLite-board.patch 	\
	file://0002-Add-changes-originally-staged-by-xxx-for-Si114x-ALS-.patch 	\
	file://0003-Add-device-tree-binding.patch 				\
	file://0004-add-flexcan.patch 						\
	file://0005-Remove-TI_ST-nodes-in-favour-of-using-HCI_UART-firmw.patch 	\
	file://0006-Add-touchscreen-driver.patch				\
	file://0007-add-panel-definition-for-ER-TFT050-3.patch			\
	file://0008-Add-touchscreen-display-backlight-and-bluetooth-RFKi.patch  \
	file://0009-gpio-rfkiller-with-devicetree-support.patch			\
"

KERNEL_MODULE_AUTOLOAD += "gslx680_ts_acpi imx-ipuv3-crtc imxdrm parallel-display"

COMPATIBLE_MACHINE = "(mx6)"
