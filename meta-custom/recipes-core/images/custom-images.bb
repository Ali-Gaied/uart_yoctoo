SUMMARY = "Custom Minimal Image with Qt EGLFS and QUItBattery"
DESCRIPTION = "core-image-minimal + Qt5 EGLFS + QUItBattery"
LICENSE = "MIT"

inherit core-image

IMAGE_OVERHEAD_FACTOR ?= "1.0"
IMAGE_ROOTFS_SIZE ?= "204800"

# Paquets de base et outils
IMAGE_INSTALL = " \
    packagegroup-core-boot \
    openssh \
    python3 \
    python3-pip \
    mesa \
    libinput \
    libxkbcommon \
    liberation-fonts \
"

IMAGE_INSTALL:append = " \
    qtbase \
    qtdeclarative \
    qtgraphicaleffects \
    qtindic \
    quitbattery \
"

EXTRA_IMAGE_FEATURES ?= "debug-tweaks"