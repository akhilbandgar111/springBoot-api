CREATE TABLE IF NOT EXISTS public.product_load_details
(
    load_id integer NOT NULL DEFAULT nextval('payload_table_loadid_seq'::regclass),
    loading_point character varying(50) COLLATE pg_catalog."default" NOT NULL,
    unloading_point character varying(60) COLLATE pg_catalog."default" NOT NULL,
    product_type character varying(60) COLLATE pg_catalog."default" NOT NULL,
    truck_type character varying(50) COLLATE pg_catalog."default" NOT NULL,
    noof_trucks integer NOT NULL,
    weight integer NOT NULL,
    optional character varying(70) COLLATE pg_catalog."default" NOT NULL,
    shipper_id character varying(100) COLLATE pg_catalog."default" NOT NULL,
    date date NOT NULL,
    is_deleted integer,
    CONSTRAINT payload_table_pkey PRIMARY KEY (load_id)
)

TABLESPACE pg_default;

ALTER TABLE public.product_load_details
    OWNER to postgres;