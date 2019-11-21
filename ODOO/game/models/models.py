# -*- coding: utf-8 -*-

from odoo import models, fields, api


class player(models.Model):
    _name = 'game.player'
    name = fields.Char()
    planetes = fields.One2many('game.planets', 'player')
    resources = fields.Many2many('game.resource')
    raws = fields.One2many('game.raws', 'player')


class planets(models.Model):
    _name = 'game.planets'
    name = fields.Char()
    player = fields.Many2one('game.player')
    image = fields.Binary()
    template = fields.Boolean()
    resources = fields.One2many('game.resource', 'planets')


class resource(models.Model):
    _name = 'game.resource'
    name = fields.Char()
    productions = fields.One2many('game.production', 'resource')
    # o consumeix
    costs = fields.One2many('game.cost', 'resource')
    image = fields.Binary()
    planets = fields.Many2one('game.planets')
    level = fields.Integer()
    template = fields.Boolean()


class production(models.Model):
    _name = 'game.production'
    name = fields.Char()
    resource = fields.Many2one('game.resource')
    level = fields.Integer()
    raw = fields.Many2one('game.raw')
    production = fields.Float()


class cost(models.Model):
    _name = 'game.cost'
    name = fields.Char()
    resource = fields.Many2one('game.resource')
    level = fields.Integer()
    raw = fields.Many2one('game.raw')
    cost = fields.Float()


class raw(models.Model):
    _name = 'game.raw'
    name = fields.Char()
    image = fields.Binary()
    public_hash = fields.Char()
    hidden_hash = fields.Char()


    materiaOscura = fields.Float()
    metal = fields.Float()
    cristal = fields.Float()
    hidrazina = fields.Float()
    energia = fields.Float()


class raws(models.Model):
    _name = 'game.raws'
    name = fields.Char()
    player = fields.Many2one('game.player')
    raw = fields.Many2one('game.raw')
    quantity = fields.Float()
