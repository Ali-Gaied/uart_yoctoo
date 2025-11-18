SUMMARY = "QUItIndicators components with EGLFS support"
HOMEPAGE = "http://quitcoding.com/?page=work#cinex"
LICENSE = "CLOSED"

DEPENDS = "qtdeclarative qtgraphicaleffects"
RDEPENDS:${PN} = "qtdeclarative-qmlplugins qtgraphicaleffects-qmlplugins qtbase"

SRC_URI = "file://main.cpp \
    file://QUItIndicators.pro \
    file://qtquick2applicationviewer.h \
    file://qtquick2applicationviewer.cpp \
    file://qtquick2applicationviewer.pri \
    file://qml \
"

S = "${WORKDIR}"
inherit qmake5

do_configure() {
    cd ${S}
    qmake QUItIndicators.pro
}

do_compile() {
    cd ${S}
    oe_runmake
}

do_install() {
    install -d ${D}${datadir}/${PN}
    
    if [ -f ${S}/QUItIndicators ]; then
        install -m 0755 ${S}/QUItIndicators ${D}${datadir}/${PN}/
    fi
    
    if [ -d ${S}/qml ]; then
        cp -R ${S}/qml ${D}${datadir}/${PN}/
    fi
    
    # Script de lancement optimisé pour EGLFS
    install -d ${D}${bindir}
    cat > ${D}${bindir}/quitindicators << 'EOF'
#!/bin/sh
cd /usr/share/qtindic
export QT_QPA_PLATFORM=eglfs
export QT_QPA_EGLFS_HIDECURSOR=1
export QT_QPA_EGLFS_ROTATION=0
./QUItIndicators
EOF
    chmod +x ${D}${bindir}/quitindicators
}

FILES:${PN} += "${datadir}/${PN}"