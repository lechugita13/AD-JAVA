/****************************************************************************
** Meta object code from reading C++ file 'mainwindow.h'
**
** Created by: The Qt Meta Object Compiler version 67 (Qt 5.12.2)
**
** WARNING! All changes made in this file will be lost!
*****************************************************************************/

#include "mainwindow.h"
#include <QtCore/qbytearray.h>
#include <QtCore/qmetatype.h>
#if !defined(Q_MOC_OUTPUT_REVISION)
#error "The header file 'mainwindow.h' doesn't include <QObject>."
#elif Q_MOC_OUTPUT_REVISION != 67
#error "This file was generated using the moc from 5.12.2. It"
#error "cannot be used with the include files from this version of Qt."
#error "(The moc has changed too much.)"
#endif

QT_BEGIN_MOC_NAMESPACE
QT_WARNING_PUSH
QT_WARNING_DISABLE_DEPRECATED
struct qt_meta_stringdata_VentanaPrincipal_t {
    QByteArrayData data[13];
    char stringdata0[157];
};
#define QT_MOC_LITERAL(idx, ofs, len) \
    Q_STATIC_BYTE_ARRAY_DATA_HEADER_INITIALIZER_WITH_OFFSET(len, \
    qptrdiff(offsetof(qt_meta_stringdata_VentanaPrincipal_t, stringdata0) + ofs \
        - idx * sizeof(QByteArrayData)) \
    )
static const qt_meta_stringdata_VentanaPrincipal_t qt_meta_stringdata_VentanaPrincipal = {
    {
QT_MOC_LITERAL(0, 0, 16), // "VentanaPrincipal"
QT_MOC_LITERAL(1, 17, 10), // "slotCerrar"
QT_MOC_LITERAL(2, 28, 0), // ""
QT_MOC_LITERAL(3, 29, 10), // "slotCopiar"
QT_MOC_LITERAL(4, 40, 9), // "slotPegar"
QT_MOC_LITERAL(5, 50, 10), // "slotCortar"
QT_MOC_LITERAL(6, 61, 9), // "slotNuevo"
QT_MOC_LITERAL(7, 71, 11), // "slotGuardar"
QT_MOC_LITERAL(8, 83, 10), // "slotCambio"
QT_MOC_LITERAL(9, 94, 12), // "slotEscribir"
QT_MOC_LITERAL(10, 107, 26), // "slotRecalcularHerramientas"
QT_MOC_LITERAL(11, 134, 9), // "slotAbrir"
QT_MOC_LITERAL(12, 144, 12) // "slotDesigner"

    },
    "VentanaPrincipal\0slotCerrar\0\0slotCopiar\0"
    "slotPegar\0slotCortar\0slotNuevo\0"
    "slotGuardar\0slotCambio\0slotEscribir\0"
    "slotRecalcularHerramientas\0slotAbrir\0"
    "slotDesigner"
};
#undef QT_MOC_LITERAL

static const uint qt_meta_data_VentanaPrincipal[] = {

 // content:
       8,       // revision
       0,       // classname
       0,    0, // classinfo
      11,   14, // methods
       0,    0, // properties
       0,    0, // enums/sets
       0,    0, // constructors
       0,       // flags
       0,       // signalCount

 // slots: name, argc, parameters, tag, flags
       1,    0,   69,    2, 0x0a /* Public */,
       3,    0,   70,    2, 0x0a /* Public */,
       4,    0,   71,    2, 0x0a /* Public */,
       5,    0,   72,    2, 0x0a /* Public */,
       6,    0,   73,    2, 0x0a /* Public */,
       7,    0,   74,    2, 0x0a /* Public */,
       8,    0,   75,    2, 0x0a /* Public */,
       9,    0,   76,    2, 0x0a /* Public */,
      10,    0,   77,    2, 0x0a /* Public */,
      11,    0,   78,    2, 0x0a /* Public */,
      12,    0,   79,    2, 0x0a /* Public */,

 // slots: parameters
    QMetaType::Void,
    QMetaType::Void,
    QMetaType::Void,
    QMetaType::Void,
    QMetaType::Void,
    QMetaType::Void,
    QMetaType::Void,
    QMetaType::Void,
    QMetaType::Void,
    QMetaType::Void,
    QMetaType::Void,

       0        // eod
};

void VentanaPrincipal::qt_static_metacall(QObject *_o, QMetaObject::Call _c, int _id, void **_a)
{
    if (_c == QMetaObject::InvokeMetaMethod) {
        auto *_t = static_cast<VentanaPrincipal *>(_o);
        Q_UNUSED(_t)
        switch (_id) {
        case 0: _t->slotCerrar(); break;
        case 1: _t->slotCopiar(); break;
        case 2: _t->slotPegar(); break;
        case 3: _t->slotCortar(); break;
        case 4: _t->slotNuevo(); break;
        case 5: _t->slotGuardar(); break;
        case 6: _t->slotCambio(); break;
        case 7: _t->slotEscribir(); break;
        case 8: _t->slotRecalcularHerramientas(); break;
        case 9: _t->slotAbrir(); break;
        case 10: _t->slotDesigner(); break;
        default: ;
        }
    }
    Q_UNUSED(_a);
}

QT_INIT_METAOBJECT const QMetaObject VentanaPrincipal::staticMetaObject = { {
    &QMainWindow::staticMetaObject,
    qt_meta_stringdata_VentanaPrincipal.data,
    qt_meta_data_VentanaPrincipal,
    qt_static_metacall,
    nullptr,
    nullptr
} };


const QMetaObject *VentanaPrincipal::metaObject() const
{
    return QObject::d_ptr->metaObject ? QObject::d_ptr->dynamicMetaObject() : &staticMetaObject;
}

void *VentanaPrincipal::qt_metacast(const char *_clname)
{
    if (!_clname) return nullptr;
    if (!strcmp(_clname, qt_meta_stringdata_VentanaPrincipal.stringdata0))
        return static_cast<void*>(this);
    return QMainWindow::qt_metacast(_clname);
}

int VentanaPrincipal::qt_metacall(QMetaObject::Call _c, int _id, void **_a)
{
    _id = QMainWindow::qt_metacall(_c, _id, _a);
    if (_id < 0)
        return _id;
    if (_c == QMetaObject::InvokeMetaMethod) {
        if (_id < 11)
            qt_static_metacall(this, _c, _id, _a);
        _id -= 11;
    } else if (_c == QMetaObject::RegisterMethodArgumentMetaType) {
        if (_id < 11)
            *reinterpret_cast<int*>(_a[0]) = -1;
        _id -= 11;
    }
    return _id;
}
QT_WARNING_POP
QT_END_MOC_NAMESPACE
