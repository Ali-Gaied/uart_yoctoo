# Add more folders to ship with the application, here
folder_01.source = qml
#folder_01.target = qml
DEPLOYMENTFOLDERS = folder_01

# Additional import path used to resolve QML modules in Creator's code model
QML_IMPORT_PATH =

# The .cpp file which was generated for your project. Feel free to hack it.
SOURCES += main.cpp

QT += quick qml

CONFIG += c++11

TARGET = QUItIndicators
TEMPLATE = app

# Please do not modify the following two lines. Required for deployment.
include(qtquick2applicationviewer.pri)
qtcAddDeployment()
