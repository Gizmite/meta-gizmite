# Provides the i.MX common settings for Gizmite devices

include conf/machine/include/soc-family.inc

# Set specific make target and binary suffix
PREFERRED_PROVIDER_u-boot ??= "u-boot-fslc"
PREFERRED_PROVIDER_virtual/bootloader ??= "u-boot-fslc"

UBOOT_MAKE_TARGET ?= "u-boot.imx"

UBOOT_SUFFIX ?= "imx"

UBOOT_ENTRYPOINT_mx6  = "0x10008000"
UBOOT_ENTRYPOINT_mx6sl = "0x80008000"
UBOOT_ENTRYPOINT_mx6sx = "0x80008000"
UBOOT_ENTRYPOINT_mx7 = "0x80008000"

# Add image FS types from fsl bsp for now
# TODO: replace with Gizmite specific image types

IMAGE_CLASSES += "image_types_fsl"

PREFERRED_PROVIDER_virtual/xserver = "xserver-xorg"
XSERVER_DRIVER = "xf86-video-armada"
XSERVER = "xserver-xorg \
           xf86-input-evdev \
           ${XSERVER_DRIVER}"

# Ship kernel modules
MACHINE_EXTRA_RRECOMMENDS = "kernel-modules"

# Tunes for hard/soft float-point selection. Note that we allow building for
# thumb support giving distros the chance to enable thumb by setting
# ARM_INSTRUCTION_SET = "thumb"
#
# handled by software
# DEFAULTTUNE_mx6 ?= "cortexa9t-neon"
# handled by hardware
DEFAULTTUNE_mx6 ?= "cortexa9thf-neon"
DEFAULTTUNE_mx6ul ?= "cortexa7thf-neon"
DEFAULTTUNE_mx7 ?= "cortexa7thf-neon"

# Sub-architecture support
MACHINE_SOCARCH_SUFFIX ?= ""

MACHINE_ARCH_FILTER = "virtual/kernel"
MACHINE_SOCARCH_FILTER_append = " virtual/libopenvg virtual/libgles1 virtual/libgles2 virtual/egl virtual/mesa virtual/libgl virtual/libg2d"

# Firmware
MACHINE_FIRMWARE ?= "linux-firmware"

MACHINE_EXTRA_RRECOMMENDS += "${MACHINE_FIRMWARE}"

# Extra udev rules
MACHINE_EXTRA_RRECOMMENDS += "udev-rules-imx"

# etnaviv GPU libraries
PREFERRED_PROVIDER_drm = "libdrm-etnaviv"
PREFERRED_PROVIDER_libdrm = "libdrm-etnaviv"
PREFERRED_PROVIDER_mesa = "mesa-etnaviv"
PREFERRED_PROVIDER_virtual/mesa = "mesa-etnaviv"
PREFERRED_PROVIDER_virtual/egl = "mesa-etnaviv"
PREFERRED_PROVIDER_virtual/libgles1 = "mesa-etnaviv"
PREFERRED_PROVIDER_virtual/libgles2 = "mesa-etnaviv"
PREFERRED_PROVIDER_virtual/libgl = "mesa-etnaviv"
PREFERRED_PROVIDER_virtual/libgl = "mesa-etnaviv"

# Handle default kernel
IMX_DEFAULT_KERNEL = "linux-gizmite"

PREFERRED_PROVIDER_virtual/kernel ??= "${IMX_DEFAULT_KERNEL}"

SDCARD_ROOTFS ?= "${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.rootfs.ext4"
IMAGE_FSTYPES ?= "sdcard.gz"

SERIAL_CONSOLE = "115200 ttymxc1"

KERNEL_IMAGETYPE = "zImage"

MACHINE_FEATURES = "bluetooth screen touchscreen usbgadget vfat wifi"

# Add the ability to specify _imx machines
MACHINEOVERRIDES =. "imx:"


