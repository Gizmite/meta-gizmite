# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)
#
# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
#
# NOTE: multiple licenses have been detected; if that is correct you should separate
# these in the LICENSE value using & if the multiple licenses all apply, or | if there
# is a choice between the multiple licenses. If in doubt, check the accompanying
# documentation to determine which situation is applicable.
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYRIGHT;md5=b6b8b946862fbf7dd78a93c8099c0bd9 \
                    file://src/common/rapidxml/license.txt;md5=905e75e8ebc74605ca2ef23063a2a5d3 \
                    file://src/vscp/drivers/level1/tellstick/win32/old/COPYING;md5=0636e73ff0215e8d672dc4c32c317bb3 \
                    file://src/vscp/drivers/level1/lirc/windows/winlirc0651/COPYING;md5=079b27cd65c86dbc1b6997ffde902735 \
                    file://src/vscp/samples/node_js/node-red-node-vscp-events/LICENSE;md5=2ee41112a44fe7014dce33e26468ba93 \
                    file://debian/copyright;md5=850f9dfb680f3b262d18f8414c7ef215 \
                    file://doc-pak/COPYRIGHT;md5=850f9dfb680f3b262d18f8414c7ef215 \
                    file://config_examples/web/COPYRIGHT;md5=5e6968fbfec2be52402e72db2f6ed9bd \
                    file://config_examples/web/LICENSE;md5=e030810821a10079b91ca12183fd1b9a \
                    file://dok-pak/COPYING;md5=850f9dfb680f3b262d18f8414c7ef215"

SRC_URI = "git://github.com/grodansparadis/vscp.git;protocol=https \
	file://0001-Add-fix-for-building-without-LUA-support.patch \
	file://0002-Add-openssl-header-to-fix-compile-error.patch  \
	file://0003-Cheap-hack-to-solve-compile-error-with-wxWidgets-2.9.patch \
	file://0004-ifndef-further-routines-that-rely-on-lua.patch \
	file://0005-Change-was-in-wx2.9.patch \
	"

# Modify these as desired
PV = "1.0+git${SRCPV}"
SRCREV = "${AUTOREV}"

CXXFLAGS += "-std=gnu++11"

S = "${WORKDIR}/git"

# NOTE: the following library dependencies are unknown, ignoring: curses pcap
#       (this is based on recipes that have previously been built and packaged)
DEPENDS = "zlib openssl wxwidgets libpcap"
RDEPENDS_${PN} = "zlib openssl wxwidgets libpcap"
# NOTE: if this software is not capable of being built in a separate build directory
# from the source, you should replace autotools with autotools-brokensep in the
# inherit line
inherit autotools-brokensep pkgconfig binconfig

# Specify any options you want to pass to the configure script using EXTRA_OECONF:
EXTRA_OECONF = 	"--enable-ssl \
		 --disable-lua \
		"

do_install () {

        install -d ${D}${bindir}
	install -d ${D}${libdir}/vscp
	install -d ${D}${servicedir}/vscp/actions
	install -d ${D}${servicedir}/vscp/certs
	install -d ${D}${servicedir}/vscp/web/css
	install -d ${D}${servicedir}/vscp/web/images
	install -d ${D}${servicedir}/vscp/web/lib
	install -d ${D}${servicedir}/vscp/web/testws
	install -d ${D}${servicedir}/vscp/tables
	install -d ${D}${localstatedir}/log/vscp
	install -d ${D}${sysconfdir}/vscp
	install -d ${D}${sysconfdir}/init.d

	install -b -m 0755 ${S}/vscpd.startup_script_debian ${D}${sysconfdir}/init.d/vscpd
	install -b -m 0744 ${S}/config_examples/vscpd.conf_unix_distro ${D}${sysconfdir}/vscp/vscpd.conf
	install -b -m 0744 ${S}/config_examples/mimetypes.xml_distro ${D}${sysconfdir}/vscp/mimetypes.xml
	install -b -m 0744 ${S}/config_examples/dm.xml_distro ${D}${servicedir}/vscp/dm.xml
	cp -r ${S}/config_examples/web/* ${D}${servicedir}/vscp/web/

	chrpath -d ${S}/src/vscp/drivers/level1/can4vscp/linux/vscpl1_can4vscpdrv.so
	chrpath -d ${S}/src/vscp/drivers/level2/wire1/linux/vscpl2drv_wire1.so
	chrpath -d ${S}/src/vscp/drivers/level1/logger/linux/vscpl1_loggerdrv.so
	chrpath -d ${S}/src/vscp/drivers/level1/can232/linux/vscpl1_can232drv.so
	chrpath -d ${S}/src/vscp/drivers/level1/xap/linux/vscpl1_xapdrv.so
	chrpath -d ${S}/src/vscp/drivers/level1/socketcan/linux/vscpl1_socketcandrv.so
	chrpath -d ${S}/src/vscp/drivers/level2/logger/linux/vscpl2drv_logger.so
	chrpath -d ${S}/src/vscp/drivers/level2/lmsensors/linux/vscpl2drv_lmsensors.so
	chrpath -d ${S}/src/vscp/drivers/level2/socketcan/linux/vscpl2drv_socketcan.so
	chrpath -d ${S}/src/vscp/drivers/level2/mqtt/linux/vscpl2drv_mqtt.so
	chrpath -d ${S}/src/vscp/drivers/level2/tcpdrv/linux/vscpl2drv_tcpiplink.so
	chrpath -d ${S}/src/vscp/linuxvscpl1/vscpl1.so
	chrpath -d ${S}/src/vscp/helperlib/linux/libvscphelper.so
	chrpath -d ${S}/src/vscp/drivers/level2/sim/linux/vscpl2drv_sim.so
	chrpath -d ${S}/src/vscp/daemon/linux/vscpd
	chrpath -d ${S}/src/vscp/mkpasswd/mkpasswd
	chrpath -d ${S}/src/vscp/uvscpd/uvscpd
	chrpath -d ${S}/src/vscp/vscpcmd/vscpcmd

	install -b -m 0755 ${S}/src/vscp/drivers/level1/can4vscp/linux/vscpl1_can4vscpdrv.so ${D}${libdir}/vscp/vscpl1_can4vscpdrv.so
	install -b -m 0755 ${S}/src/vscp/drivers/level2/wire1/linux/vscpl2drv_wire1.so ${D}${libdir}/vscp/vscpl2drv_wire1.so
	install -b -m 0755 ${S}/src/vscp/drivers/level1/logger/linux/vscpl1_loggerdrv.so ${D}${libdir}/vscp/vscpl1_loggerdrv.so
	install -b -m 0755 ${S}/src/vscp/drivers/level1/can232/linux/vscpl1_can232drv.so ${D}${libdir}/vscp/vscpl1_can232drv.so
	install -b -m 0755 ${S}/src/vscp/drivers/level1/xap/linux/vscpl1_xapdrv.so ${D}${libdir}/vscp/vscpl1_xapdrv.so
	install -b -m 0755 ${S}/src/vscp/drivers/level1/socketcan/linux/vscpl1_socketcandrv.so ${D}${libdir}/vscp/vscpl1_socketcandrv.so
	install -b -m 0755 ${S}/src/vscp/drivers/level2/logger/linux/vscpl2drv_logger.so ${D}${libdir}/vscp/vscpl2drv_logger.so
	install -b -m 0755 ${S}/src/vscp/drivers/level2/lmsensors/linux/vscpl2drv_lmsensors.so ${D}${libdir}/vscp/vscpl2drv_lmsensors.so
	install -b -m 0755 ${S}/src/vscp/drivers/level2/socketcan/linux/vscpl2drv_socketcan.so ${D}${libdir}/vscp/vscpl2drv_socketcan.so
	install -b -m 0755 ${S}/src/vscp/drivers/level2/mqtt/linux/vscpl2drv_mqtt.so ${D}${libdir}/vscp/vscpl2drv_mqtt.so
	install -b -m 0755 ${S}/src/vscp/drivers/level2/tcpdrv/linux/vscpl2drv_tcpiplink.so ${D}${libdir}/vscp/vscpl2drv_tcpiplink.so
	install -b -m 0755 ${S}/src/vscp/linuxvscpl1/vscpl1.so ${D}${libdir}/vscp/vscpl1.so
	install -b -m 0755 ${S}/src/vscp/helperlib/linux/libvscphelper.so ${D}${libdir}/vscp/libvscphelper.so
	install -b -m 0755 ${S}/src/vscp/daemon/linux/vscpd ${D}${bindir}/vscpd
	install -b -m 0755 ${S}/src/vscp/mkpasswd/mkpasswd ${D}${bindir}/mkpasswd
	install -b -m 0755 ${S}/src/vscp/uvscpd/uvscpd ${D}${bindir}/uvscpd
	install -b -m 0755 ${S}/src/vscp/vscpcmd/vscpcmd ${D}${bindir}/vscpcmd
	install -b -m 0755 ${S}/src/vscp/drivers/level2/sim/linux/vscpl2drv_sim.so ${D}${libdir}/vscp/vscpl2drv_sim.so

	rm -r -f ${D}${localstatedir}
	
}

FILES_${PN} = "${bindir} ${libdir}/vscp ${servicedir}/vscp ${sysconfdir}/vscp ${sysconfdir}/init.d"

