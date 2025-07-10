import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewApplicationComponent } from './view-application.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { RouterTestingModule } from '@angular/router/testing';

describe('ViewApplicationComponent', () => {
  let component: ViewApplicationComponent;
  let fixture: ComponentFixture<ViewApplicationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FormsModule,ReactiveFormsModule, HttpClientModule, RouterTestingModule],
      declarations: [ ViewApplicationComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewApplicationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  fit('Frontend_day31_create_View_Application_Component with jobs array', () => {
    expect(component).toBeTruthy();
    expect((component as any).jobs).toBeDefined();
    expect(Array.isArray((component as any).jobs)).toBe(true);
  });
});
