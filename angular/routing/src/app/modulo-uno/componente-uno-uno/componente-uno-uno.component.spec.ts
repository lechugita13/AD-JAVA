import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ComponenteUnoUnoComponent } from './componente-uno-uno.component';

describe('ComponenteUnoUnoComponent', () => {
  let component: ComponenteUnoUnoComponent;
  let fixture: ComponentFixture<ComponenteUnoUnoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ComponenteUnoUnoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ComponenteUnoUnoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
